package com.codecool.kuku.display;


import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;


public class CardComponent extends JPanel{

    private BufferedImage cardImage;
    private double scaleCard;

	public CardComponent(BufferedImage cardImage) {
		super();
        this.cardImage = cardImage;
        scaleCard = 0.8;

		Dimension dimension = new Dimension((int)(cardImage.getWidth() * scaleCard), (int)(cardImage.getHeight() * scaleCard));
		setPreferredSize(dimension);
	}

    public CardComponent(BufferedImage cardImage, double scaleCard) {
		super();
        this.cardImage = cardImage;
        this.scaleCard = scaleCard;

		Dimension dimension = new Dimension((int)(cardImage.getWidth() * scaleCard), (int)(cardImage.getHeight() * scaleCard));
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.scale(scaleCard, scaleCard);
		g2d.drawImage(cardImage, 0, 0, this);
	}


    public void changeCard(BufferedImage cardImage) {
        this.cardImage = cardImage;
        repaint();
    }

    public void setScaleCard(double scaleCard) {
        this.scaleCard = scaleCard;
    }
}
