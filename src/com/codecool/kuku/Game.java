package com.codecool.kuku;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {

    List<Card> deck = new ArrayList<>();

    Game() {

    }

    public void initPiles() {

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

    }

}