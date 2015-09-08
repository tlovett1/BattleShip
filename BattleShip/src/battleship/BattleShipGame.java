
package battleship;

import java.util.Scanner;
import javax.swing.JOptionPane;

///////////////////////////////////////////////////////////////////////////////                  

// Title:            BattleShip (2D Array Review)
// Files:            BattleShipGame.java, Battleship.java
// Semester:         COP3337 Fall 2015
// TeamName:         The Force
// Author:           5120019, 4890534
// Lecturer's Name:  Christy Charters
//
// Description of Program’s Functionality: Generates Battleship Game for player,
// Lets user know whether they hit or miss ships.
//
//////////////////////////// 80 columns wide/////////////////////////////////
public class BattleShipGame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Battleship myGame = new Battleship();// TODO code application logic here
        String input = null;
        String playAgain = null;
        do
        {
        JOptionPane.showMessageDialog(null, String.format("             "
                + "              Welcome to the game of Battleship %n"
                + "       In this game a 5 by 5 game board will be created with"
                + " random %n   battleship locations. You will be given four "
                + "attempts to find them %n                            "
                + "   If you find "
                + "all four you win!!!!" + " %n(" + "Please enter your attempts"
                + " in this form: ex (row/column) = (5,5)" + ")"));
       myGame.initialize_ship_locations();
       
         for(int i = 1; i < 5; i++)
        {
           input = JOptionPane.showInputDialog("Guess " + i);
           
           if(input == null)
           {
               System.out.println("Thanks for playing");
               break;
           }
           else
           {
           Scanner myScan = new Scanner(input);
           int k = myScan.useDelimiter(",").nextInt();
           int j = myScan.useDelimiter(",").nextInt();
           myGame.process_user_guess(k, j);
           }
        }
         if(input != null)
         {
          myGame.displayBattleshipGame();
          myGame.clear_ship_locations();
          playAgain = JOptionPane.showInputDialog("Do you want to play again? Y"
                  + "/N");
         }
         else
         {
             break;
         }
        }
        while(playAgain.equalsIgnoreCase("Y") );
    }
        
}

