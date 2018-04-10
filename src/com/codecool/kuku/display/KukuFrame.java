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
    private JPanel cardsPanel, leftComputersPanel, rightComputersPanel;
    private JLabel background, computersLabel;


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
        leftComputersPanel = new JPanel(new GridLayout(5, 1));
        rightComputersPanel = new JPanel(new GridLayout(5, 1));
        leftComputersPanel = generateMenuComputers(leftComputersPanel);
        rightComputersPanel = generateMenuComputers(rightComputersPanel);
        background.add(leftComputersPanel, BorderLayout.EAST);
        background.add(rightComputersPanel, BorderLayout.WEST);
    }

    private JPanel generateMenuComputers(JPanel computersPanel) {
        computersLabel = new JLabel("Computers");
        computersPanel.add(computersLabel);
        computersPanel.setBackground(new Color(0, 0, 0, 0));
        return computersPanel;
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
