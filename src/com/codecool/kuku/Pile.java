package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;

public class Pile {

    private List<Card> cards;

    public Pile(String pileOwner) {
        cards = new ArrayList<Card>();
    }

    public String getPileOwner() {
        return pileOwner;
    }

    public ArrayList<Card> getCards() {
        return ArrayList<Card> cards;
    }
}

