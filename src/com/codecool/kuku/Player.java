package com.codecool.kuku;

import java.util.List;
import java.util.Map;

/**
 * This is a abstract class representing players.
 */
public abstract class Player{

    /**
     * check cards for possible kuku.
     * @return true if kuku
     */
    public abstract boolean checkKuku();

    /**
     * Calculates best move.
     * @return card to give
     */
    public abstract Card handleNextMove();

    /**
     * Add  cards to list.
     * @return list of used cards
     */
    public abstract List handleCardsOnHand();

    public abstract Map possiblessOpponentsKuku();

    public abstract Pile getPile();
}