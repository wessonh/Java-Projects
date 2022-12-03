// Henry Wesson
// CS 145
// Lab 5 - Towers of Hanoi
// November, 10, 2022

import java.util.Scanner;

public class HWMenu
{
    public static int menu()
    {
        int maxDiscs = 10; // sets max discs, once the count got higher...
                           // the program started slowing down and acting weird. limited to ten to be safe
        int disc = 0; // sets intRing to zero initially
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Towers of Hanoi simulator!");
        System.out.print("\nHow many discs would you like to play with? (Max Discs " + maxDiscs + "): ");

        while(disc < 1 || disc > maxDiscs) // while loop to run menu for user input
        {
            String stringRing = keyboard.nextLine();

            try // start of try catch to catch invalid number outside bounds
            {
                disc = Integer.parseInt(stringRing); // had to use parseInt for this to work correctly

                if(disc < 1 || disc > maxDiscs) // if the number is invalid
                {
                    System.out.print("Error! Please enter a valid number: ");
                }
            }
            catch(Exception e) // catches exception of non-numerical input
            {
                System.out.println("Please enter a number between 1 and " + maxDiscs + ": ");
            }
        } // end while
        return disc;
    } // end menu method
} // end menu class
