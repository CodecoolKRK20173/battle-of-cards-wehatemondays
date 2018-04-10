package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pile {

    private List<Card> cards;

    public Pile() {
        this.cards = new ArrayList<>();
    }


    // public void passCard(Card card, Pile destPile) {
    //     cards.remove(card);
    //     destPile.add(card);

    // }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public String toString() {
        StringBuilder pileAsString = new StringBuilder();
        for (Card card : cards) {
            pileAsString.append(card);
        }
        return pileAsString.toString();
    }
}

