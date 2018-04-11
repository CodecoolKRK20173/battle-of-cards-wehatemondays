package com.codecool.kuku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Game {

    List<Card> deck;
    List<Player> players;
    List<Player> playersWithKuku;
    Pile stock;

    Game(int playersAmmount) {
        stock = new Pile();
        deck = Card.createDeckInPile();
        playersWithKuku = new ArrayList<>();
        initPlayers(playersAmmount);
        dealCards();
    }

    public void handleRound() {
        while(!isRoundDone()){
            
            for (int i = 0; i < players.size(); i++) {

                Player currentPlayer = players.get(i);

                // /// adding to kuku list
                // playersWithKuku.add(currentPlayer);
                // /// checking kuku mechanics
                // if (playersWithKuku.contains(currentPlayer)) {
                //     continue;
                // }

                Card cardToPass = currentPlayer.chooseCard();
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
    }

    private boolean isRoundDone() {
        if (players.size() == playersWithKuku.size() - 1) {
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

}