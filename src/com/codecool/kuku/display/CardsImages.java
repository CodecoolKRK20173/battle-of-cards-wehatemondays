package com.codecool.kuku.display;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class CardsImages {

    private Map<String, BufferedImage> cardsImage;
    private String nameTheme;
    private File imageFile;
    private final String IMAGE_PATH = "resources/card_images/";


    public CardsImages() {
        nameTheme = "default_cards/";
        loadImages(nameTheme);
    }

    private void loadImages(String nameTheme) {
        cardsImage = new HashMap<>();

        try {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    String nameCard = suit.getSuitName() + rank.getRankName();
                    imageFile = new File(IMAGE_PATH + nameTheme + nameCard + ".png");
                    BufferedImage cardImage = ImageIO.read(imageFile);
                    cardsImage.put(nameCard, cardImage);
                }
                imageFile = new File(IMAGE_PATH + nameTheme + "card_back.png");
                BufferedImage cardImage = ImageIO.read(imageFile);
                cardsImage.put("card_back", cardImage);
                imageFile = new File(IMAGE_PATH + nameTheme + "empty_pile.png");
                cardImage = ImageIO.read(imageFile);
                cardsImage.put("empty_pile", cardImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, BufferedImage> getCards() {
        return cardsImage;
    }

    public enum Suit {
        HEARTS("hearts"),
        DIAMONDS("diamonds"),
        SPADES("spades"),
        CLUBS("clubs");

        private String suitName;

        Suit(String suitName){
            this.suitName = suitName;
        }

        public String getSuitName() {
            return suitName;
        }
    }

    public enum Rank {
        ACE("1"),
        NINE("9"),
        TEN("10"),
        JACK("11"),
        QUEEN("12"),
        KING("13");

        private String rankName;

        Rank(String rankName){
            this.rankName = rankName;
        }

        public String getRankName() {
            return rankName;
        }
    }
}
