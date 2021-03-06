package com.codecool.kuku.display;

import com.codecool.kuku.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;


public class KukuFrame extends JFrame implements MouseListener {

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 700;

    private int numberOfComputers;
    private JMenuBar menuBar;
    private JMenu menuGame;
    private JMenuItem menuItemNewGame, menuItemExit;
    private int indexHumanPlayer;
    private List<Card> humanCards;
    private Card destCard;
    private CardComponent stockCards;
    private CardComponent[] playerCardComponent;
    private CardComponent[][] computerCardComponent;
    private CardsImages cardsImages;
    private Map<String, BufferedImage> cards;
    private JPanel cardsPanel, computersPanel, buttonsPanel, stockPanel;
    private JLabel background;
    private JLabel[] computersLabel;
    private Game game;
    private List<Player> players;
    private JButton handleMoveButton, reportKukuButton;
    private boolean cardBackInPile = false;

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
        addMenuBar();
    }

    private void addMenuBar() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuGame = new JMenu("Game");
        menuItemNewGame = new JMenuItem("New Game");
        menuItemExit = new JMenuItem("Exit");
        menuGame.add(menuItemNewGame);
        menuGame.add(menuItemExit);
        menuBar.add(menuGame);

        menuItemNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStockCardComponent();
                deleteComputersPanel();
                showEmptyHumanPiles();
                deleteButtons();
                initializeGame();
                refreshHumanCards();
                showHumanCards();
                addComputersPanels();
                addButtons();
                addStockPile();
                pack();
                setSize(getPrefferedSize());
            }
        });

        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
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

    private void initializeGame() {
        Object[] possibilities = {1, 2, 3, 4};
        numberOfComputers = (int)JOptionPane.showInputDialog(null,
            "Choose number of computers: ", "Customized Dialog",
            JOptionPane.PLAIN_MESSAGE, null, possibilities, 1);

            game = new Game(numberOfComputers + 1);
            players = game.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof Human) {
                indexHumanPlayer = i;
            }
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

    private void addButtons() {
        handleMoveButton = new JButton("Handle move");
        reportKukuButton = new JButton("Report KUKU");
        handleMoveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (destCard != null) {
                    game.handleRound(destCard);
                    refreshHumanCards();
                    showHumanCards();
                    cardBackInPile = false;
                }
            }
        });

        reportKukuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SuitEnum suit = SuitEnum.HEARTS;
                RankEnum rank = RankEnum.ACE;
                game.handleRound(new Card(suit, rank));
                if (!game.checkIfKuku()) {
                    JOptionPane.showMessageDialog(null, "You are cheater.", "Alert!", JOptionPane.ERROR_MESSAGE);
                } else {
                    showRanking();
                }
            }
        });

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 2));
        buttonsPanel.setBackground(new Color(0, 0, 0, 0));
        buttonsPanel.add(handleMoveButton);
        buttonsPanel.add(reportKukuButton);
        background.add(buttonsPanel, BorderLayout.WEST);
    }

    private void showRanking() {
        String ranking = "";
        List<Player> playersWithKuku = game.getPlayersWithKuku();
        for (int i = 0; i < playersWithKuku.size(); i++) {
            if (playersWithKuku.get(i) instanceof Human) {
                ranking += (i + 1) + ". Human\n";
            } else {
                ranking += (i + 1) + ". " + playersWithKuku.get(i).getPlayerName() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, ranking, "Alert!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteButtons() {
        if (buttonsPanel != null) {
            background.remove(buttonsPanel);
        }
    }

    private void deleteStockCardComponent() {
        if (stockPanel != null) {
            background.remove(stockPanel);
        }
    }

    private void addStockPile() {
        stockCards = new CardComponent(cards.get("card_back"));
        stockPanel = new JPanel();
        stockPanel.addMouseListener(this);
        stockPanel.setBackground(new Color(0, 0, 0, 0));
        stockPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        stockPanel.add(stockCards);
        background.add(stockPanel, BorderLayout.CENTER);
    }

    private void showHumanCards() {
        int indexCardComponent = 0;
        for (Card card : humanCards) {
            String nameCard = CardsImages.getNameOfCard(card.getEnumSuit(), card.getEnumRank());
            playerCardComponent[indexCardComponent].changeCard(cards.get(nameCard));
            System.out.println(nameCard);
            indexCardComponent++;
        }
    }

    private void showEmptyHumanPiles() {
        for (CardComponent component : playerCardComponent) {
            component.changeCard(cards.get("empty_pile"));
        }
    }

    private void deleteComputersPanel() {
        if (computersPanel != null) {
            background.remove(computersPanel);
            pack();
            setSize(getPrefferedSize());
        }
    }

    private void refreshHumanCards() {
        players = game.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof Human) {
                indexHumanPlayer = i;
                System.out.println("human" + indexHumanPlayer);
            }
        }
        Pile humanPile = players.get(indexHumanPlayer).getPile();
        humanCards = humanPile.getPile();
    }

    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (cardBackInPile == true && !game.isRoundDone()) {
            showHumanCards();
            cardBackInPile = false;
        }

        for (int i = 0; i < playerCardComponent.length; i++) {
            if (source == playerCardComponent[i] && cardBackInPile == false && !game.isRoundDone()) {
                playerCardComponent[i].changeCard(cards.get("card_back"));
                destCard = humanCards.get(i);
                cardBackInPile = true;

            }
        }

        if (source == stockPanel && game.isCardCanBeChanged(destCard)) {
            game.changeCard(destCard);
            refreshHumanCards();
            showHumanCards();
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
