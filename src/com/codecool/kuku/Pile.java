package com.codecool.kuku;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pile {

    private List<Card> cards;

    public Pile(String pileOwner) {
        cards = new ArrayList<Card>();
    }

    public void createDeckInPile() {
        for (SuitEnum suit : SuitEnum.values()) {
            for (RankEnum rank : RankEnum.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public void passCard(Card card, Pile destPile) {
        cards.remove(card);
        destPile.add(card);
        // dest pile, card
        // reimplement equals to remove card: 
    // public boolean equals(Card card) {
    //     if (card.getRank() == this.rank() && card.getSuit() == this.suit()){
    //         return true;
    //     }
    //     return false;
    // }
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

    public void toString() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}

