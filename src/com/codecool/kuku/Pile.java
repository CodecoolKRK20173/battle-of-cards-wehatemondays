package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pile {

    private List<Card> cards;

    public Pile() {
        cards = new ArrayList<Card>();
    }


    public void passCard(Card card, Pile destPile) {
        cards.remove(card);
        destPile.add(card);

    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getPileOwner() {
        return pileOwner;
    }

    public ArrayList<Card> getCards() {
        return ArrayList<Card> cards;
    }

    public String toString() {
        StringBuilder pileAsString = new StringBuilder();
        for (Card card : cards) {
            pileAsString.append(card);
        }
        return pileAsString.toString();
    }
}

