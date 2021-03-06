package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pile {

    private List<Card> cards;

    public Pile() {
        this.cards = new ArrayList<Card>();
    }


    // public void passCard(Card card, Pile destPile) {
    //     cards.remove(card);
    //     destPile.add(card);

    // }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getPile() {
        return this.cards;
    }

    public void removeFromPile(Card card) {
        cards.remove(card);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int getPileSize() {
        return cards.size();
    }

    public String toString() {
        StringBuilder pileAsString = new StringBuilder();
        for (Card card : cards) {
            pileAsString.append(card + " | ");
        }
        return pileAsString.toString();
    }

    public Card getCardRank(int rank) {
        int x = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getRank() == rank) {
                x = i;
                return cards.get(i);
            }
        }
        return cards.get(x);
    }

    public Card getCardSuit(int suit) {
        int x = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit() == suit) {
                x = i;
                return cards.get(i);
            }
        }
        return cards.get(x);
    }
}

