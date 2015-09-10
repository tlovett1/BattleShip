package battleship;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

///////////////////////////////////////////////////////////////////////////////                  
// Title:            BattleShip (2D Array Review)
// Files:            BattleShipGame.java, Battleship.java
// Semester:         COP3337 Fall 2015
// TeamName:         The Force
// Author:           4890534
// Lecturer's Name:  Christy Charters
//
// Description of Program’s Functionality: Generates Battleship Game for player,
// Lets user know whether they hit or miss ships.
//
//////////////////////////// 80 columns wide/////////////////////////////////
public class BattleShipGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Battleship myGame = new Battleship();// TODO code application logic here
        String input = null;
        String playAgain = null;

        int gamesWon = 0;
        int gamesLost = 0;
        String[] checkInput = new String[5];
        do {
            JOptionPane.showMessageDialog(null, String.format("             "
                + "              Welcome to the game of Battleship %n"
                + "       In this game a 5 by 5 game board will be created with"
                + " random %n   battleship locations. You will be given four "
                + "attempts to find them %n                            "
                + "   If you find "
                + "all four you win!!!!" + " %n(" + "Please enter your attempts"
                + " in this form: ex (row,column) = (5,5)" + ")"));

            myGame.initialize_ship_locations();
            Arrays.fill(checkInput, null);
            for (int i = 1; i < 5; i++) {
                input = JOptionPane.showInputDialog("Guess #" + i);

                if (input == null) {
                    System.out.println("Thanks for playing");
                    break;
                } else {
                    Scanner myScan = new Scanner(input);
                    int k = myScan.useDelimiter(",").nextInt();
                    int j = myScan.useDelimiter(",").nextInt();

                    while (Arrays.asList(checkInput).contains(input)) {
                        input = JOptionPane.showInputDialog("The same numbers "
                           + "have been previously entered. Please try again");

                        while (k >= 6 || j >= 6) {
                            input = JOptionPane.showInputDialog("One of your "
                            + "guesses is greater than five. Please try again");

                            myScan = new Scanner(input);
                            k = myScan.useDelimiter(",").nextInt();
                            j = myScan.useDelimiter(",").nextInt();
                            if (k <= 5 && j <= 5) {
                                break;
                            }
                        }
                    }
                    while (k >= 6 || j >= 6) {
                       input = JOptionPane.showInputDialog("One of your guesses"
                               + " is greater than five. Please try again");

                        myScan = new Scanner(input);
                        k = myScan.useDelimiter(",").nextInt();
                        j = myScan.useDelimiter(",").nextInt();
                        if (k <= 5 && j <= 5) {
                            break;
                        }
                    }

                    myGame.process_user_guess(k, j);
                    checkInput[i] = input;

                }
            }
            if (input != null) {
                myGame.displayBattleshipGame();
                if (myGame.userWon()) {
                    System.out.println("\nCongrats, you sunk all 4 ships!!!!");
                    gamesWon++;
                } else {
                System.out.println("\nShips Sunk: " + myGame.getTotalShipsSunk()
                            + "\nShips Missed: " + myGame.getTotalMisses());
                    gamesLost++;
                }

                System.out.println("Games Won: " + gamesWon + "\nGames Lost: "
                        + gamesLost);
                myGame.clear_ship_locations();
                playAgain = JOptionPane.showInputDialog("Do you want to play "
                        + "again? Y/N");
                if (playAgain != "y" || playAgain != "yes") {
                    System.out.println("\nThanks for playing, have a good day!");
                    break;
                }
            } else {
                break;
            }
        } while (playAgain.equalsIgnoreCase("Y"));
    }
}
