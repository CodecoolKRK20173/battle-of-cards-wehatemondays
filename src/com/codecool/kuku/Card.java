package com.codecool.kuku;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Card {

    private int rank;
    private int suit;
    private RankEnum enumRank;
    private SuitEnum enumSuit;
    private Pile containingPile;

    public Card(SuitEnum suit, RankEnum rank) {
        this.suit = suit.getSuit();
        this.rank = rank.getRank();
        enumSuit = suit;
        enumRank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public SuitEnum getEnumSuit() {
        return enumSuit;
    }

    public RankEnum getEnumRank() {
        return enumRank;
    }

    public Pile getContainingPile() {
        return containingPile;
    }

    public static List<Card> createDeckInPile() {
        List<Card> result = new ArrayList<>();
        for (SuitEnum suit : SuitEnum.values()) {
            for (RankEnum rank : RankEnum.values()) {
                result.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(result);
        return result;
    }

    public String toString() {
        StringBuilder newString = new StringBuilder();
        newString.append("rank : " + String.valueOf(rank) + " suit : " + String.valueOf(suit));
        return newString.toString();
    }
}
