package com.codecool.kuku;

import java.util.Random;
public class Ai extends Player{
    public interface getNumberCard {
        public card metoda(Card card);
    }
    public boolean checkKuku(){
        if(isSameSuit(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)))
                    return true; 
        
        if(isSameRank(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)))
                    return true;            
        
        return false;
    }

    public card handleNextMove(){
        Random rndC = new Random();

        if(playersPile.isSameSuit(playersPile.getCard(0),playersPile.getCard(3)) ||
        playersPile.isSameRank(playersPile.getCard(0),playersPile.getCard(3))){
            random = getRandomWithExclusion(rndC,0,4,i,i+1);
            return playersPile.getCard(random);
        }

        for(int i=0; i < 3; i++){
            if(playersPile.isSameSuit(playersPile.getCard(i),playersPile.getCard(i+1)) ||
            playersPile.isSameRank(playersPile.getCard(i),playersPile.getCard(i+1))){
            random = getRandomWithExclusion(rndC,0,4,i,i+1);
            return playersPile.getCard(random);
            }
        }
        return playersPile.getCard(rndc.nextInt(4));
    }

    private int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
}