package com.codecool.kuku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game {

    private List<Card> deck;
    private List<Player> players;
    private List<Player> playersWithKuku;
    private Pile stock;

    public Game(int playersAmmount) {
        stock = new Pile();
        deck = Card.createDeckInPile();
        playersWithKuku = new ArrayList<>();
        initPlayers(playersAmmount);
        dealCards();
    }

    public void handleRound(Card cardHuman) {

        removeFromPlayersList(); //if player has kuku TODO

        for (int i = 0; i < players.size(); i++) {

            Player currentPlayer = players.get(i);

            if (currentPlayer.checkKuku()) playersWithKuku.add(currentPlayer);
            // /// adding to kuku list
            // playersWithKuku.add(currentPlayer);
            // /// checking kuku mechanics
            if (currentPlayer instanceof Human) {
                Card cardToPass = cardHuman;
            }
            else {
                Card cardToPass = currentPlayer.chooseCard();
            }
            //TODO String list with info
            System.out.println("Turn: " + currentPlayer.getPlayerName());
            System.out.println("Start cards:  " + String.valueOf(currentPlayer.getPile().getPileSize()));

            if (i + 1 < players.size()) {
                players.get(i+1).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
                System.out.println("moving card: " + cardToPass);
            }
            else {
                players.get(0).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
                System.out.println("moving card: " + cardToPass);
            }

            System.out.println("Final cards:  " + String.valueOf(currentPlayer.getPile().getPileSize()) + "\n");
            System.out.println("End player: ");
            ////// Wordks fine //////
            // System.out.println(player.getPlayerName());
            // Pile playersCards = player.getPile();
            // System.out.println("Players cards: ");
            // for (int i = 0; i < playersCards.getPileSize(); i++) {
            //     System.out.println(playersCards.getCard(i));
            // }
            // System.out.println("end player: ");
        }

    }

     private boolean isRoundDone() {
        if (players.size() == 1) {
            return true;
        }
        return false;
    }

    private void initPlayers(int playersAmmount) {
        this.players = new ArrayList<>();
        players.add(new Human("You"));

        for (int i = 0; i < playersAmmount - 1; i++) {
            players.add(new Ai("Player " + String.valueOf(i + 1)));
        }
    }

    private void dealCards() {
        Collections.shuffle(players);
        Iterator<Card> deckIterator = deck.iterator();

        for (int i = 0; i < 3; i++) {
            for (Player x : players) {
                x.getPile().addCard(deckIterator.next());
                System.out.println("Adding one card to one player");
            }
        }
        players.get(0).getPile().addCard(deckIterator.next());
        deckIterator.forEachRemaining(card -> {
            stock.addCard(card);
        });
    }

    public void setHumanKuku() {
        //user has kuku (from GUI)
    };

    public boolean ifPlayerGuess() {
        //if player guess right suit or rank
        return true;
    }

}
