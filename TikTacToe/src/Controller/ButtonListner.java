/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tiktactoe.UserInterface.UI;

/**
 *
 * @author deepu
 */
public class ButtonListner implements ActionListener {

    JLabel gameTitle;  //trim this
    JButton mainButton;
    JButton[][] allButtons;
    JFrame frame;

    public ButtonListner(JLabel gameTitle, JButton mainButton, JButton[][] allButtons, JFrame frame) {
        this.gameTitle = gameTitle;
        this.mainButton = mainButton;
        this.allButtons = allButtons;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if ("X's Turn".equals(gameTitle.getText().trim())) {
            mainButton.setText("X");
            mainButton.setBackground(Color.RED);
            gameTitle.setText("        O's Turn");
        } else if ("O's Turn".equals(gameTitle.getText().trim())) {
            mainButton.setText("O");
            mainButton.setBackground(Color.BLUE);
            gameTitle.setText("        X's Turn");
        }
        mainButton.setEnabled(false);
        String symbol = mainButton.getText();
        Boolean checkOne = true;                                                                        //to check one condition

        for (int i = 0; i < 3; i++) {                                                                    //check right diagonal
            if (!allButtons[i][i].getText().equals(symbol)) {
                checkOne = checkOne && false;
            }
        }
        if (checkOne) {
            declearWinner();
            return;
        }

        if (allButtons[2][0].getText().equals(symbol) && allButtons[1][1].getText().equals(symbol)
                && allButtons[0][2].getText().equals(symbol)) {                                               //left diagonal
            declearWinner();
            return;
        }

        for (int i = 0; i < 3; i++) {                                                                       //check rows
            checkOne = true;
            for (int j = 0; j < 3; j++) {
                if (!allButtons[i][j].getText().equals(symbol)) {
                    checkOne = checkOne && false;
                }
            }
            if (checkOne) {

                declearWinner();
                return;
            }

        }

        for (int i = 0; i < 3; i++) {                                                                       //check columns
            checkOne = true;
            for (int j = 0; j < 3; j++) {
                if (!allButtons[j][i].getText().equals(symbol)) {
                    checkOne = checkOne && false;
                }
            }
            if (checkOne) {
                declearWinner();
                return;
            }
        }
        checkOne = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (allButtons[j][i].getText().isEmpty()) {
                    checkOne = false;
                }
            }
        }
        if (checkOne) {
            frame.getContentPane().removeAll();
            UI.frameComponents(frame.getContentPane(), frame);
            frame.getContentPane().setLayout(new GridLayout(5, 3));
            frame.getContentPane().add(new JLabel(""));
            frame.getContentPane().add(new JLabel("Last round was a tie"));
            frame.getContentPane().add(new JLabel(""));
        }

    }

    public void declearWinner() {
        frame.getContentPane().removeAll();
        UI.frameComponents(frame.getContentPane(), frame);
        frame.getContentPane().setLayout(new GridLayout(5, 3));
        frame.getContentPane().add(new JLabel(""));
        frame.getContentPane().add(new JLabel(mainButton.getText() + " is the winner in last round"));
        frame.getContentPane().add(new JLabel(""));

    }

}
