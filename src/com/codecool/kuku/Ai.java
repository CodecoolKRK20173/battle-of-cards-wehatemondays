package com.codecool.kuku;

import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Ai extends Player{

    public Pile playersPile;
    public String name;

    public Ai(String name){
        this.playersPile = new Pile();
        this.name = name;
    }
   
    public boolean checkKuku(){
        if(Card.isSameSuit(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)))
                    return true; 
        
        if(Card.isSameRank(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)))
                    return true;            
        
        return false;
    }

    public Card handleNextMove(){
        Random rndC = new Random();

        for (int i = 0; i < 3; i++) {
            if(Card.isSameSuit(playersPile.getCard(0),playersPile.getCard(3)) ||
        Card.isSameRank(playersPile.getCard(0),playersPile.getCard(3))){
            int[] exclusion = {i, i + 1};
            int random = getRandomWithExclusion(rndC,0,4,exclusion);
            return playersPile.getCard(random);
        }
    }

        for(int i=0; i < 3; i++){
            if(Card.isSameSuit(playersPile.getCard(i),playersPile.getCard(i+1)) ||
            Card.isSameRank(playersPile.getCard(i),playersPile.getCard(i+1))){
            Random nextRnd = new Random();
            int[] exclusion = {i, i + 1};
            int random2 = getRandomWithExclusion(rndC,0,4,exclusion);
            return playersPile.getCard(random2);
            }
        }
        Random finalRnd = new Random();
        return playersPile.getCard(finalRnd.nextInt(4));
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

    public Map<String, Integer> possiblessOpponentsKuku() {
        System.out.println("Not implemented yet");
        return new HashMap<String, Integer>();
    }

    public List handleCardsOnHand() {
        System.out.println("Not implemented yet");
        return new ArrayList<String>();
    }
    //// TEMP TESTING PURPOSE
    public Card chooseCard() {
        return playersPile.getCard(0);
    }

    public static boolean equals(Player player1, Player player2) {
        if (player1.getPlayerName().equals(player2.getPlayerName())) {
            return true;
        }
        return false;
    }

    public String getPlayerName() {
        return name;
    }

    public Pile getPile() {
        return this.playersPile;
    }
}