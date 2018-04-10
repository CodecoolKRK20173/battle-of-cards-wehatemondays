package com.codecool.kuku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game {

    List<Card> deck;
    List<Player> players;

    Game(int playersAmmount) {
        this.deck = new ArrayList<Card>();
        initPiles();
        dealCards(playersAmmount);
    }

    public void initPiles() {

        Pile stock = new Pile();
        this.players = new ArrayList<>();
        Player player1 = new Human();
        players.add(player1);
        Player player2 = new Ai();
        players.add(player2);
        Player player3 = new Ai();
        players.add(player3);
        Player player4 = new Ai();
        players.add(player4);
        Player player5 = new Ai();
        players.add(player5);
    }

    public void dealCards(int playersAmmount) {
        Collections.shuffle(players);
        Iterator<Card> deckIterator = deck.iterator();
        for (int i = 0; i < playersAmmount ; i++ ){
            for (int j = 0; j < 2; j++ ) {
                Card card = deckIterator.next();
                Player player = players.get(i);
                player.getPile().addCard(card);
                deck.remove(card);
            }
        }
        Card lastCard = deckIterator.next();
        players.get(0).getPile().addCard(lastCard);
        deck.remove(lastCard);


    }

}