package com.codecool.kuku;

import java.util.ArrayList;

/**
 * This is a abstract class representing players.
 */
public abstract class Player{


    public Player(){
        Pile playersPile = new Pile();
    }
    /**
     * check cards for possible kuku.
     * @return true if kuku
     */
    public abstract boolean checkKuku();

    /**
     * Calculates best move.
     * @return card to give
     */
    public abstract card handleNextMove();

    /**
     * Add  cards to list.
     * @return list of used cards
     */
    public abstract ArrayList handleCardsOnHand();

    public abstract HashMap possiblessOpponentsKuku();
}