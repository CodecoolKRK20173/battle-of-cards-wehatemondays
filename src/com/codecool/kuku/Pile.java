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



    public void addCard(Card card) {
        cards.add(card);
    }

    public String getPileOwner() {
        return pileOwner;
    }

    public ArrayList<Card> getCards() {
        return ArrayList<Card> cards;
    }
}

