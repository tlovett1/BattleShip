/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.util.Random;

/**
 *
 * @author cristy
 */
public class Battleship 
{
    Random shipSpot = new Random();
    boolean ship_locations[][] = new boolean[5][5];
    boolean guess_locations[][] = new boolean[5][5];
    int totalShipsSunk;
    int totalMisses;
    
    public Battleship()
    {
        
    }
    
    
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
    
    public void clear_ship_locations()
    {
        for(int i = 0; i < ship_locations.length; i++)
        {
            for(int k = 0; k < ship_locations[i].length; k++)
            {
                ship_locations[i][k] = false;
            }
        }
        totalShipsSunk = 0;
        totalMisses = 0;
    }
    
    
    public void process_user_guess(int row, int col)
    {
       guess_locations[row][col] = true;
        
       for(int i = 0; i < guess_locations.length; i++)
        {
            for(int k = 0; k < guess_locations[i].length; k++)
            {
                if(guess_locations[i][k] == ship_locations[i][k])
                {
                    totalShipsSunk++;
                }
                totalMisses++;
            }
        }
        
    }
    
    public boolean userWon()
    {
        if(totalShipsSunk == 4)
        {
            return true;
        }
        
        return false;
    }
    
    public void displayBattleshipGame()
    {
        System.out.println("User Guesses");

        for (int i = 0; i < guess_locations.length; i++)
        {
            for (int k = 0; k < guess_locations[i].length; k++)
            {
                if (guess_locations[i][k] == true) 
                {
                    System.out.print("  " + "X" + " \t");
                } 
                else 
                {
                    System.out.print("*" + "\t");
                }
            }
            System.out.println("");
        }
        
        System.out.println("\nGame Board");
        for (int i = 0; i < ship_locations.length; i++) 
        {

            for (int k = 0; k < ship_locations[i].length; k++) 
            {

                if (ship_locations[i][k] == true) 
                {
                    System.out.print("  " + "X" + " \t");
                } 
                else 
                {
                    System.out.print("*" + "\t");
                }
            }
            System.out.println("");
        }

    }
}
    

