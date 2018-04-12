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
        StringBuilder gameLog = new StringBuilder();
        removeFromPlayersList(); //if player has kuku TODO

        for (int i = 0; i < players.size(); i++) {
            
            Player currentPlayer = players.get(i);
            gameLog.append(currentPlayer.getPlayerName() + "'s turn:\n'");

            if (currentPlayer.checkKuku()) playersWithKuku.add(currentPlayer);
            // /// adding to kuku list
            //gameLog.append(currentPlayer.getPlayerName() + " have reported Kuku!\n");
            // playersWithKuku.add(currentPlayer);
            // /// checking kuku mechanics
            Card cardToPass; //////// ->>>> what card?
            if (currentPlayer instanceof Human) {
                cardToPass = cardHuman;
                gameLog.append("You have passed " + cardToPass.toString() + " to ");
            }
            else {
                cardToPass = currentPlayer.chooseCard();
                gameLog.append(players.get(i).getPlayerName() + " passed card to ");
            }

            if (i + 1 < players.size()) {
                players.get(i+1).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
                gameLog.append(players.get(i+1).getPlayerName() + ". \n\n");
            }
            else {
                players.get(0).getPile().addCard(cardToPass);
                players.get(i).getPile().removeFromPile(cardToPass);
                gameLog.append(players.get(0).getPlayerName() + ". \n\n");
            }
        }
        String turnLog = gameLog.toString();
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
        int NUMBEROFCARDSKUKU = 3;
        for (int i = 0; i < NUMBEROFCARDSKUKU; i++) {
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
    // public boolean canHumanKuku(Human human){
    //     return human.checkKuku();
    // }
    
    // More likely like thizzz, but I'm not sure if catch this right. 
    // if not I'll sort that one out tomo

        //user has kuku (from GUI)
        // check it!!

    };

    // public ifPlayerGuess() {
    //     //if player guess right suit or rank
    // }

    public void removeFromPlayersList() {

        if (!playersWithKuku.isEmpty()) {
            for (int i = 0; i < playersWithKuku.size(); i++) {
                Player playerWithKuku = playersWithKuku.get(i);

                for (int x = 0; x < players.size(); x++) {
                    if (players.get(x).equals(playerWithKuku)) {
                        players.remove(x);
                    }
                }
            }
        }
    }
    public boolean ifPlayerGuess() {
        //if player guess right suit or rank
        return true;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
