package com.codecool.kuku.display;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.awt.image.BufferedImage;


public class KukuFrame extends JFrame implements MouseListener {

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 700;

    private int numberOfComputers = 4;

    private JButton button;
    private CardComponent[] playerCardComponent;
    private CardComponent[][] computerCardComponent;
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
        background.addMouseListener(this);

        showMenuCards();

        addComputersPanels();

    }

    private void addComputersPanels() {
        computersPanel = new JPanel(new GridLayout(1, 4));
        background.add(computersPanel, BorderLayout.NORTH);
        computersLabel = new JLabel[numberOfComputers];
        computerCardComponent = new CardComponent[numberOfComputers][3];
        for (int i = 0; i < computerCardComponent.length; i++) {
            for (int j = 0; j < computerCardComponent[i].length; j++) {
                computerCardComponent[i][j] = new CardComponent(cards.get("card_back"), 0.5);
            }
        }

        for (int i = 0; i < numberOfComputers; i++) {
            computersLabel[i] = new JLabel("Computer " + (i + 1) + " ");
            computersPanel.add(getComputerCardPanel(computerCardComponent[i], i));
        }
    }

    private JPanel getComputerCardPanel(CardComponent[] cardComponent, int numberOfComp) {
        JPanel computerCardPanel = new JPanel();
        JPanel pilesCardPanel = new JPanel();
        computerCardPanel.setLayout(new BorderLayout());
        computerCardPanel.add(computersLabel[numberOfComp], BorderLayout.NORTH);
        for (CardComponent component : cardComponent) {
            pilesCardPanel.add(component);
            pilesCardPanel.setSize(10, 10);
            component.addMouseListener(this);
        }
        computerCardPanel.add(pilesCardPanel, BorderLayout.SOUTH);
        return computerCardPanel;
    }

    private void showMenuCards() {
        playerCardComponent = new CardComponent[4];

        cardsPanel = new JPanel();
        cardsPanel.setBackground(new Color(0, 0, 0, 0));
        background.add(cardsPanel, BorderLayout.SOUTH);

        for (int i = 0; i < playerCardComponent.length; i++) {
            playerCardComponent[i] = new CardComponent(cards.get("empty_pile"));
            playerCardComponent[i].addMouseListener(this);
            cardsPanel.add(playerCardComponent[i]);
        }
    }

    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.getClass() == CardComponent.class){
            CardComponent card= (CardComponent)source;
            card.changeCard(cards.get("clubs1"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source.getClass() == CardComponent.class) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
