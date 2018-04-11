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