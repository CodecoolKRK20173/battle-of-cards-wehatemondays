package com.codecool.kuku.display;


import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;


public class CardComponent extends JPanel{

    private BufferedImage cardImage;

	public CardComponent(BufferedImage cardImage) {
		super();
        this.cardImage = cardImage;

		Dimension dimension = new Dimension(cardImage.getWidth(), cardImage.getHeight());
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(cardImage, 0, 0, this);
	}


    public void changeCard(BufferedImage cardImage) {
        this.cardImage = cardImage;
        repaint();
    }
}
