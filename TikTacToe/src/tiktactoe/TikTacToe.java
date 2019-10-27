/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktactoe;

import javax.swing.*;
import tiktactoe.UserInterface.UI;
/**
 *
 * @author deepu
 */
public class TikTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UI ui=new UI();
        SwingUtilities.invokeLater(ui);
    }
    
}
