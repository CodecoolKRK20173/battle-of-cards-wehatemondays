package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;

public class Pile {

    private List<Card> cards;
    private String pileOwner;

    public Pile(String pileOwner) {
        this.pileOwner = pileOwner;
        cards = new ArrayList<Card>();
    }

    public String getPileOwner() {
        return pileOwner;
    }

    public List<Card> getCards() {
        return List<Card> cards;
    }

}

