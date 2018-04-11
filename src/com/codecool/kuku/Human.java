package com.codecool.kuku;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Human extends Player{

    public Pile playersPile;
    public String name;
    
    public Human(String name) {
        this.playersPile = new Pile();
        this.name = name;
    }

    private Map<String, Integer> checkColors() {
        HashMap<String, Integer> colors = new HashMap<>();

        for (Card card : playersPile) {
            String color = card.getSuit();
            Integer previousValue = colors.get(color);

            if(previousValue == null){
                previousValue = 0;
            }
            colors.put(color, previousValue + 1);
        }
        return colors;
    }

    private Map<String, Integer> checkRanks() {
        HashMap<String, Integer> ranks = new HashMap<>();

        for (Card card : playersPile) {
            String rank = card.getRank();
            Integer previousValue = ranks.get(rank);

            if(previousValue == null){
                previousValue = 0;
            }
            ranks.put(rank, previousValue + 1);
        }
        return ranks;
    }

    public boolean checkKuku(){
        System.out.println("Not implemented yet");
        return false;
    }

    public Card handleNextMove(){
        System.out.println("Not implemented yet");
        return playersPile.getCard(0);
    }

    public List handleCardsOnHand() {
        System.out.println("Not implemented yet");
        return new ArrayList<String>();
    }

    public Map possiblessOpponentsKuku() {
        System.out.println("Not implemented yet");
        return new HashMap<String, Integer>();
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
        return playersPile;
    }
}