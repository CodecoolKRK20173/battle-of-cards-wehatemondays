package com.codecool.kuku;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


/**
 * This is a abstract class representing players.
 */
public abstract class Player{

    public Pile playersPile;
    public String name;

    public Player(String name) {
        this.playersPile = new Pile();
        this.name = name;
    }
    /**
     * Calculates best move.
     * @return card to give
     */
   public abstract Card handleNextMove();

    /**
     * Add  cards to list.
     * @return list of used cards
     */

    public abstract Map possiblessOpponentsKuku();

    public abstract Pile getPile();

    public abstract String getPlayerName();

    //// TEMP TESTING PURPOSE
    public abstract Card chooseCard();

    public Map<String, Integer> checkColors() {
        HashMap<String, Integer> colors = new HashMap<>();

        for (int i = 0; i < playersPile.getPileSize(); i ++) {
            Card card = playersPile.getCard(i);
            String color = String.valueOf(card.getSuit());
            Integer previousValue = colors.get(color);

            if(previousValue == null){
                previousValue = 0;
            }
            colors.put(color, previousValue + 1);
        }
        return colors;
    }

    public Map<String, Integer> checkRanks() {
        HashMap<String, Integer> ranks = new HashMap<>();

        for (int i = 0; i < playersPile.getPileSize(); i ++) {
            Card card = playersPile.getCard(i);
            String rank = String.valueOf(card.getRank());
            Integer previousValue = ranks.get(rank);

            if(previousValue == null){
                previousValue = 0;
            }
            ranks.put(rank, previousValue + 1);
        }
        return ranks;
    }

    public boolean checkKuku(){
        Map<String, Integer> colors = checkColors();
        List<Integer> noOfCardsInColor = new ArrayList<Integer>(colors.values());
        Map<String, Integer> ranks = checkRanks();
        List<Integer> noOfCardsInRank = new ArrayList<Integer>(ranks.values());

        if (noOfCardsInColor.contains(3) || noOfCardsInRank.contains(3)) {
            System.out.println("Kuku");
            return true;
            }
        System.out.println("Nie ma Kuku");
        return false;
    }
}
