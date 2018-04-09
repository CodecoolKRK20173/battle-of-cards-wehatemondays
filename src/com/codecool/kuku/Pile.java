package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;

public class Pile {

    private List<Card> cards;

    public Pile(String pileOwner) {
        cards = new ArrayList<Card>();
    }

    public void createDeckInPile() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public String getPileOwner() {
        return pileOwner;
    }

    public ArrayList<Card> getCards() {
        return ArrayList<Card> cards;
    }
}

