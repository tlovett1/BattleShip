
package battleship;

import java.util.Random;

public class Battleship 
{
    //instance var's
    Random shipSpot = new Random();                   //generates random numbers
    private boolean ship_locations[][] = new boolean[5][5];   //ships array
    private boolean guess_locations[][] = new boolean[5][5];  //user guess array
    private int totalShipsSunk = 0;                           //total ships sunk
    private int totalMisses = 0;                              //total misses
    
    /**
     * Initializes a Battleship object.
     */
    public Battleship() 
    {}
    
    /**
     * Initializes random ship locations.
     */
    public void initialize_ship_locations() 
    {
        int row = shipSpot.nextInt(5) + 0;
        int column = shipSpot.nextInt(5) + 0;
        ship_locations[row][column] = true;
        int temp = row;
        int temp2 = column;

        for (int i = 0; i < 3; i++) 
        {
            row = shipSpot.nextInt(5) + 0;
            column = shipSpot.nextInt(5) + 0;

            //safeguard
            while (ship_locations[temp][temp2] == ship_locations[row][column]) 
            {
                row = shipSpot.nextInt(5) + 0;
                column = shipSpot.nextInt(5) + 0;
            }
            ship_locations[row][column] = true;
        }
    }
    
    /**
     * Clear Ship locations at the end of the game.
     * 
     */
    public void clear_ship_locations() 
    {
        for (int i = 0; i < ship_locations.length; i++) 
        {
            for (int k = 0; k < ship_locations[i].length; k++) 
            {
                ship_locations[i][k] = false;
                guess_locations[i][k] = false;
            }
        }
        totalShipsSunk = 0;
        totalMisses = 0;
    }
    
    /**
     * Processes user input into their guess display and increments hits and 
     * misses.
     * @param row sets the inputted row
     * @param col sets the inputted col
     */
    public void process_user_guess(int row, int col) 
    {
        guess_locations[row - 1][col - 1] = true;

        if(guess_locations[row - 1][col - 1] == 
                ship_locations[row - 1][col - 1]) 
        {
            totalShipsSunk++;
        }
       totalMisses = 4 - totalShipsSunk;
    }
    
    /**
     * Checks if user won the battleship match.
     * @return Boolean(true or false)
     */
    public boolean userWon() 
    {
        if (totalShipsSunk == 4) 
        {
            return true;
        }

        return false;
    }
    
    /**
     * Prints the user and random ship game board and total misses and hits
     * they have
     */
    public void displayBattleshipGame() 
    {
        System.out.println("\n\t   User Guesses");
        for (int i = 0; i < guess_locations.length; i++) 
        {
            for (int k = 0; k < guess_locations[i].length; k++) 
            {
                if (guess_locations[i][k] == true) 
                {
                    System.out.print("\u2715" + " \t");
                } 
                else 
                {
                    System.out.print("\u25CF" + "\t");
                }
            }
            System.out.println("");
        }

        System.out.println("\n\t   Game Board");
        for (int i = 0; i < ship_locations.length; i++) 
        {
            for (int k = 0; k < ship_locations[i].length; k++) 
            {
                if (ship_locations[i][k] == true) {
                    System.out.print("\u2715" + " \t");
                } else {
                    System.out.print("\u25CF" + "\t");
                }
            }
            System.out.println("");
        }
    }
    
    /**
     * Gets total Ships sunk
     * @return total ships sunk
     */
    public int getTotalShipsSunk()
    {
        return totalShipsSunk;
    }
    
    /**
     * Gets total Missed ships
     * @return total ships missed
     */
    public int getTotalMisses()
    {
        return totalMisses;
    }
}
