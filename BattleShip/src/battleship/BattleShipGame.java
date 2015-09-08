/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kennetpostigo
 */
public class BattleShipGame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Battleship myGame = new Battleship();// TODO code application logic here
        
        JOptionPane.showMessageDialog(null, String.format("             "
                + "              Welcome to the game of Battleship. %n"
                + "       In this game a 5 by 5 game board will be created with "
                + "random %n   battleship locations. You will be given four "
                + "attempts to find them %n                            "
                + "   If you find "
                + "all four you win!!!!" + " %n(" + "Please enter your attempts "
                + "in this form: ex (row/column) = (5/5)" + ")"));
       myGame.initialize_ship_locations();
       
        myGame.displayBattleshipGame();
    }
    
}

