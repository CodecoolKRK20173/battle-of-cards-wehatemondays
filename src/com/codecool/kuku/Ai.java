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
    public HashMap<String, Card> movedCards;
    public ArrayList<String> kukuList;

    public Ai(String name){
        this.playersPile = new Pile();
        this.name = name;
        this.movedCards.put("playerOnLeft", null);
        this.movedCards.put("playerOnRight", null);
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
        int random;
        for (int i = 0; i < 3; i++) {
            if(Card.isSameSuit(playersPile.getCard(i),playersPile.getCard(i+1)) ||
            Card.isSameRank(playersPile.getCard(i),playersPile.getCard(i+1))){
            int[] exclusion = {i, i + 1};
            random = getRandomWithExclusion(rndC,0,4,exclusion);
            movedCards.put("playerOnLeft", getCard(random));
            return playersPile.getCard(random);
        }
    }
        for(int i=0; i < 3; i++){
            if(Card.isSameSuit(playersPile.getCard(i),playersPile.getCard(i+1)) ||
            Card.isSameRank(playersPile.getCard(i),playersPile.getCard(i+1))){
            int[] exclusion = {i, i + 1};
            random = getRandomWithExclusion(rndC,0,4,exclusion);
            movedCards.put("playerOnLeft", getCard(random));
            return playersPile.getCard(random);
            }
        }
        return playersPile.getCard(rndC.nextInt(4));
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

    public HashMap<String, String> getPossiblessOpponentsKuku() { //need numbers of players, suit or rank to quess
        HashMap<String, String> possiblessOpponentsKuku;            //need map with players and kuku;
        //z listy kart oddanych, ostatnia karta to kuku przeciwnika z lewej, 
        //ostatnia karta otrzymana to nie kuku goscia z prawej
        //innych kuku to prawdopodobnie nie karty ktore mam na ręce
        //prawdopodobnie to karty ktore oddlem, zliczac ilosc kolorow i ilosc figur.
        return 
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