package com.codecool.kuku;

public enum SuitEnum {
    HEARTS(1),
    DIAMONDS(2),
    SPADES(3),
    CLUBS(4);

    private final int suit;

    SuitEnum(int suit) {
        this.suit = suit;
    }

    public int getSuit() {
        return this.suit;
    }

}