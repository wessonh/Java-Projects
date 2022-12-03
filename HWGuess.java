// Henry Wesson
// 09/25/2022
// CS 145 Hybrid
// Lab 1 - Guessing Game

// This program will function as a guessing game. It will show the user how to play and pick a number between 
// 1 and a number of their choice. It will then ask the user to guess the number and tell them to 
// guess higher or lower until they get it right. It will then prompt them if they want to play again. 
// If the user gives an invalid input it will display a message and have them try again.  

import java.util.*; 

public class HWGuess // start of HWGuessing game class
{
    
    public static void main(String[] args) // start of main method
    {
        Scanner keyboard = new Scanner(System.in); // sets user input to "keyboard" 
        Random numberGenerator = new Random();     // sets  Raadom numberGenerator to Random number
        
        //defining variables
        int games = 0;
        int bestGuess = 0;
        int totalGuess = 0;
        int testGuess = 0;
        int max = 0;
        String choice = "";
        Boolean endGame = false;
        Boolean endPlayAgain = false;        
        Boolean setMax = false;
        
        instructions(); // calls game intro method  
               
        while (setMax == false) // while loop to set a max number
        {
            System.out.println();
            System.out.println("Please choose a max number: "); 
         
            try // try for valid input 
            {
                max = keyboard.nextInt();
                bestGuess = max;
                setMax = true;
            }
        
            catch (Exception e) // catches expection and displays error message
            {
                System.out.println();
                System.out.println("Numbers only!!!");
                keyboard.nextLine(); 
            }    
        } // end set max while loop
        while (endGame == false) // while loop when not ending the game
        {
            testGuess = playGame(keyboard, totalGuess, max, numberGenerator); 
            totalGuess += testGuess; // adds guesses in each game to total guesses
            endPlayAgain = false;
                        
            if (testGuess < bestGuess)  // records best guess for the summary method
            {
                bestGuess = testGuess; 
            }
            games++; // add to games played
            
            while (endPlayAgain == false)
            {             
                System.out.print("\nWould you like to play again? (y/n): "); // prompts user if they would like to play again
                choice = keyboard.next();
                char c = choice.charAt(0);
                
   
                if (c == 'y' || c == 'Y') // if the choice is y user continues the game
                {
                    endPlayAgain = true;
                    endGame = false;                
                }
            
                else if (c == 'n' || c == 'N') // if the choice is n user ends the game
                {
                    endPlayAgain = true;
                    endGame = true;                                
                }
                
                else
                {
                    System.out.println();
                    System.out.println("Please enter a valid command!");                
                }                
            }                              
            summary(bestGuess, games, totalGuess); // calls summary method
        } // end while loop
    } // end main method
    public static void instructions() // the method for the intructions
    {
        System.out.println("Welcome! This is a guessing game program. I");
        System.out.println("will pick a number between 1 and a value you choose and you");
        System.out.println("will guess until you get it right. I will tell");
        System.out.println("you if you are too high or too low until you");
        System.out.println("guess the right number.");
    } // end of method for instructions    
    
    public static int playGame(Scanner keyboard, int totalGuess, int max, Random numberGenerator) // method to play the game
    {
        System.out.println();
        System.out.println("I'm thinking of a number between 1 and " + max + "."); // computer tells player it picked a number betwee 1 and max
        
        // defines variable for play game method
        int number = numberGenerator.nextInt(max) + 1;
        Boolean endGame = false;
        int numGuess = 0;
        
        while (endGame == false) // start of while loop to keep running game until user is correct
        {
             
            System.out.println();
            System.out.print("Please guess a number: "); // prompts user to guess a number
                    
            try
            {
                int guess = keyboard.nextInt();
                numGuess++;
                totalGuess += numGuess;                                
                
                if (guess == number) // if the user gets the right answer
                {
                    System.out.println();
                    System.out.println("Congratulations! You guessed it right in " + numGuess + " guesses!"); // prints congratulations
                    endGame = true;
                } 
                else if (guess > number) // else if the user  picked higher than the number
                {
                    System.out.println();
                    System.out.println("Lower"); 
                }
                else  // else the user picked lower than the number 
                {
                    System.out.println();
                    System.out.println("Higher");    
                }
            }
            catch(Exception e)
            {
                System.out.println();
                System.out.println("Numbers only!!!");
                keyboard.nextLine();
            }
        } // end while loop
        return numGuess; // displays the number of guesses in the game
    } // end of play game method
    
    public static void summary(int bestGuess, int games, int totalGuess) // method for summary
    {
        // variables for results
        double average = ((double) totalGuess/games); // getting average Guesses/Game
        int n = 1; // int for number of decimal places for average
        average = Math.round(average * Math.pow(10, n)) / Math.pow(10, n); // rounds off the average to 1 decimal place
        
        // displays summary
        System.out.println("Results:");
        System.out.println("Games Played: " + games);
        System.out.println("Total Guesses: " + totalGuess);
        System.out.println("Best Game: " + bestGuess);
        System.out.println("Average Guesses per Game: " + average); 
        
    } // end summary method      
} // end HWGuess class        
