package com.codecool.kuku;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Ai extends Player{

    public Ai(String name){
        super(name);
    }
   
    public boolean checkKuku(){
        if(Card.isSameSuit(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)))
                    return true; 
        
        if(Card.isSameRank(playersPile.getCard(0),
                    playersPile.getCard(1),
                    playersPile.getCard(2)) &&
                    playersPile.getCard(0).getSuit() != playersPile.getCard(1).getSuit() &&
                    playersPile.getCard(1).getSuit() != playersPile.getCard(2).getSuit() &&
                    playersPile.getCard(0).getSuit() != playersPile.getCard(2).getSuit())
                    return true;            
        
        return false;
    }

    public Card handleNextMove(){

        Map<String, Integer> colors = this.checkColors();
        Map<String, Integer> ranks = this.checkRanks();

        if (colors.size() == 3) {
            for(Map.Entry<String, Integer> entry : colors.entrySet()) {
                Integer value = entry.getValue();
                if (value != 2) {
                    Integer key = Integer.valueOf(entry.getKey());
                    return this.playersPile.getCardSuit(key); //CHECK IT!!!
                }
            }
        }
        else return playersPile.getCard(generateRndomNumber(3));

        if (ranks.size() == 3) {
            for(Map.Entry<String, Integer> entry : ranks.entrySet()) {
                Integer value = entry.getValue();
                if (value != 2) {
                    Integer key = Integer.valueOf(entry.getKey());
                    return this.playersPile.getCardRank(key); //CHECK IT!!!
                }
            }
        }
        else return playersPile.getCard(generateRndomNumber(3));
        
        return playersPile.getCard(generateRndomNumber(3));
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

    private int generateRndomNumber(int max) {
        Random generator = new Random();
        int random = generator.nextInt(max);
        return random;
    }
}