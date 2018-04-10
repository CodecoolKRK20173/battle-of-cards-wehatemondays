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

    private int numberOfComputers = 4;

    private JButton button;
    private CardComponent[] playerCardComponent;
    private CardsImages cardsImages;
    private Map<String, BufferedImage> cards;
    private JPanel cardsPanel, computersPanel;
    private JLabel background;
    private JLabel[] computersLabel;


    public KukuFrame() {
        cardsImages = new CardsImages();
        cards = cardsImages.getCards();
        setSize(getPrefferedSize());
        setLayout(new BorderLayout());
    	background = new JLabel(new ImageIcon("resources/table_images/table_default.png"));
    	add(background);
    	background.setLayout(new BorderLayout());

        showMenuCards();

        addComputersAreas();

    }

    private void addComputersAreas() {
        computersPanel = new JPanel(new GridLayout(1, 8));
        background.add(computersPanel, BorderLayout.NORTH);
        computersLabel = new JLabel[numberOfComputers];
        for (int i = 0; i < numberOfComputers; i++) {
            computersLabel[i] = new JLabel("Computer " + (i + 1) + " ");
            computersLabel[i].setHorizontalAlignment(JLabel.RIGHT);
            computersPanel.add(computersLabel[i]);
            computersPanel.add(new CardComponent(cards.get("card_back")));
        }
        computersPanel.setBackground(new Color(0, 0, 0, 0));
    }

    private void showMenuCards() {
        playerCardComponent = new CardComponent[4];

        cardsPanel = new JPanel();
        cardsPanel.setBackground(new Color(0, 0, 0, 0));
        cardsPanel.setLayout(new GridLayout(1, 4));
        background.add(cardsPanel, BorderLayout.SOUTH);

        for (int i = 0; i < playerCardComponent.length; i++) {
            playerCardComponent[i] = new CardComponent(cards.get("card_back"));
            cardsPanel.add(playerCardComponent[i]);
        }

        playerCardComponent[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        playerCardComponent[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        playerCardComponent[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        playerCardComponent[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
