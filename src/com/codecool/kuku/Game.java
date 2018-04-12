package com.codecool.kuku;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Game {

    private List<Card> deck;
    private List<Player> players;
    private List<Player> playersWithKuku;
    private Pile stock;
    private Set<Card> allHumanCards;

    public Game(int playersAmmount) {
        allHumanCards = new HashSet<>();
        stock = new Pile();
        deck = Card.createDeckInPile();
        playersWithKuku = new ArrayList<>();
        initPlayers(playersAmmount);
        dealCards();
    }

    public void handleRound(Card cardHuman) {
        Card cardToPass;

        removeFromPlayersList();

        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer.checkKuku()) playersWithKuku.add(currentPlayer);

            if (currentPlayer instanceof Human) {
                cardToPass = cardHuman;
            }
            else {
                cardToPass = currentPlayer.handleNextMove();
            }
            if (i + 1 < players.size()) {
                players.get(i+1).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
            }
            else {
                allHumanCards.add(cardToPass);
                players.get(0).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
            }
        }
    }

     public boolean isRoundDone() {
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
        Iterator<Card> deckIterator = deck.iterator();
        int NUMBEROFCARDSKUKU = 3;
        for (int i = 0; i < NUMBEROFCARDSKUKU; i++) {
            for (Player x : players) {
                Card card = deckIterator.next();
                x.getPile().addCard(card);
            }
        }
        players.get(0).getPile().addCard(deckIterator.next());
        deckIterator.forEachRemaining(card -> {
            stock.addCard(card);
        });
    }

    public boolean checkIfKuku() {
        return players.get(0).checkKuku();
    }

    public boolean isCardCanBeChanged(Card card) {
        return allHumanCards.contains(card);
    }

    public void changeCard(Card card) {
        players.get(0).getPile().removeFromPile(card);
        Card cardFromStock = stock.getCard(0);
        players.get(0).getPile().addCard(cardFromStock);
        stock.removeFromPile(cardFromStock);
        stock.addCard(card);
    }

    public List<Player> getPlayersWithKuku() {
        return playersWithKuku;
    }

    public void removeFromPlayersList() {

        if (!playersWithKuku.isEmpty()) {
            for (int i = 0; i < playersWithKuku.size(); i++) {
                Player playerWithKuku = playersWithKuku.get(i);
                removePlayerwithKuku(playerWithKuku);
            }
        }
    }
    
    public void removePlayerwithKuku(Player playerWithKuku){
        for (int x = 0; x < players.size(); x++) {
            if (players.get(x).equals(playerWithKuku)) {
                players.remove(x);
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
