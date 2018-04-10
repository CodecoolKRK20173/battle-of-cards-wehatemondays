package com.codecool.kuku;

public enum RankEnum {
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ACE(1);

    private final int rank;

    CardEnum(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

   
}