package com.codecool.kuku;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Card {

    private int rank;
    private int suit;
    private Pile containingPile;

    public Card(SuitEnum suit, RankEnum rank) {
        this.suit = suit.getSuit();
        this.rank = rank.getRank();
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    public Pile getContainingPile() {
        return containingPile;
    }

    public void moveToPile(Pile destPile) {
        this.getContainingPile().getCards().remove(this);
        destPile.addCard(this);
    }

    private boolean isRed() {
        if (getSuit()==1 || getSuit()==2) {
            return true;
        }
        return false;
    }

    public static boolean isOppositeColor(Card card1, Card card2) {
        if (card1.isRed() && !card2.isRed()) return true;
        else if (!card1.isRed() && card2.isRed()) return true;
        else return false;
    }

    public static boolean isSameSuit(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit();
    }

    public static boolean isSameSuit(Card card1, Card card2, Card card3) {
        if (card1.getSuit() == card2.getSuit()) {
            if (card1.getSuit() == card3.getSuit()) return true;
        }
        return false;
    }

    public static boolean isSameRank(Card card1, Card card2) {
        return card1.getRank() == card2.getRank();
    }

    public static boolean isSameRank(Card card1, Card card2, Card card3) {
        if (card1.getRank() == card2.getRank()) {
            if (card1.getRank() == card3.getRank()) return true;
        }
        return false;
    }

    public static boolean equals(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit() && card1.getRank() == card2.getRank()) return true;
        else return false;
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
}