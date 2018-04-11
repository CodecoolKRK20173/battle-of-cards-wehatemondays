package com.codecool.kuku;

import com.codecool.kuku.display.*;
import java.awt.*;
import javax.swing.*;


public class Main{
    public static void main(String[] args){
        // AWT DEMO!
        // EventQueue.invokeLater(new Runnable()
        //     {
        //         public void run() {
        //             KukuFrame kukuFrame = new KukuFrame();
        //             kukuFrame.setTitle("Kuku");
        //             kukuFrame.setLocationRelativeTo(null);
        //             kukuFrame.setResizable(false);
        //             kukuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //             kukuFrame.setVisible(true);
        //         }

        //     });
        //MAIN TEST:

        Game newGame = new Game(3);
        System.out.println("New game created");
        newGame.handleRound();

    }
}
