package com.codecool.kuku.display;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.awt.image.BufferedImage;


public class KukuFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 700;

    private JButton button;
    private CardComponent[] playerCardComponent;
    private CardsImages cardsImages;
    private Map<String, BufferedImage> cards;
    private JPanel cardsPanel;
    private JLabel background;


    public KukuFrame() {
        cardsImages = new CardsImages();
        cards = cardsImages.getCards();
        setSize(getPrefferedSize());
        setLayout(new BorderLayout());
    	background = new JLabel(new ImageIcon("resources/table_images/table_default.png"));
    	add(background);
    	background.setLayout(new BorderLayout());
    }

    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
