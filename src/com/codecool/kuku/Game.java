package com.codecool.kuku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.codecool.klondike.Card;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

public class Game {

    List<Card> deck;
    List<Player> players;

    Game(int playersAmmount) {
        deck = new ArrayList<Card>();
        players = initPiles();
        dealCards(playersAmmount);
    }

    public LinkedList<Player> initPiles() {

        Pile stock = new Pile();
        List<Player> playerList = new LinkedList<>();
        Player player1 = new Player();
        playerList.add(player1);
        Player player2 = new Player();
        playerList.add(player2);
        Player player3 = new Player();
        playerList.add(player3);
        Player player4 = new Player();
        playerList.add(player4);
        Player player5 = new Player();
        playerList.add(player5);
        Player player6 = new Player();
        playerList.add(player6);

        return playerList;

    }

    public void dealCards(int playersAmmount) {
        playerList.shuffle();
        Iterator<Card> deckIterator = deck.iterator();
        for (int i = 0; i < playersAmmount ; i++ ){
            for (int j = 0; j < 2; j++ ) {
                Card card = deckIterator.next();
                Player player = playerList.get(i);
                player.getPile().addCard(card);
                deck.remove(card);
            }
        }
        Card lastCard = deckIterator.next();
        playerList.get(0).getPile().addCard(lastCard);
        deck.remove(lastCard);


    }

}