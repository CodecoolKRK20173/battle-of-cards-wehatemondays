package com.codecool.kuku;

public enum RankEnum {
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    ACE(1);

    private final int rank;

    RankEnum(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }
}
