package com.codecool.kuku;

public enum SuitEnum {
    HEARTS(1, "hearts"),
    DIAMONDS(2, "diamonds"),
    SPADES(3, "spades"),
    CLUBS(4, "clubs");

    private final int suit;
    private final String suitName;

    SuitEnum(int suit, String suitName) {
        this.suit = suit;
        this.suitName = suitName;
    }

    public int getSuit() {
        return this.suit;
    }

    public String getSuitName() {
        return suitName;
    }

}
