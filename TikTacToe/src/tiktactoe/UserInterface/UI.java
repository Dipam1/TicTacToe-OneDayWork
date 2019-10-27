/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktactoe.UserInterface;

import Controller.ButtonListner;
import java.awt.*;
import javax.swing.*;
import javax.swing.WindowConstants;

/**
 *
 * @author deepu
 */
public class UI implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("TikTacToe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frameComponents(frame.getContentPane(), frame);
        frame.pack();
        frame.setVisible(true);

    }

    public static void  frameComponents(Container container, JFrame frame) {
        container.setLayout(new GridLayout(4, 3));

        container.add(new JLabel(""));
        JLabel gameTitle = new JLabel("        X's Turn");
        gameTitle.setFont(new Font("Arial", Font.BOLD, 24));
        container.add(gameTitle);
        container.add(new JLabel(""));

        JButton buttons[][] = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                container.add(buttons[i][j]);
                buttons[i][j].addActionListener(new ButtonListner(gameTitle, buttons[i][j], buttons, frame));
            }

        }

    }

}
