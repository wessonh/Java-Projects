// Henry Wesson
// CS 145
// Assignment 1 - Word Search Generator
// November, 1, 2022

// This is the main for my WordSearchGenerator program. This program will accept user input to generate a word search
// out of the words the user inputs to the program. The word search size will fit the words regardless of length.
// The user will be able to view the word search, view the solution. For extra credit I used try catch where I could
// and used switch case for the menu. I also added the features for the program to make a search from a file input and
// to also be able to save a search and its solution to a file.


import java.util.*;

public class WordSearchMain
{
    public static void main(String[] args)
    {
        // variables
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        String choice;
        WordSearch search = new WordSearch();

        // start of do while to run the switch case menu to run the word search program.
        do // do while loop to loop until user quits
        {
            printIntro();
            choice = keyboard.next();
            switch (choice.toLowerCase())
            {
                case "g" -> WordSearchMenu.generate(keyboard, search);
                case "p" -> WordSearchMenu.view(search);
                case "s" -> WordSearchMenu.solution(search);
                case "o" -> WordSearchMenu.output(keyboard, search);
                case "i" -> WordSearchMenu.input(keyboard, search);
                case "q" ->
                {
                    System.out.println("Quitting program. Goodbye!\n");
                    done = true;
                }
                default -> System.out.println("Please enter a valid command!\n");
            }
        }
        while (!done);
    }
    // Method that prints program intro and instructions. Explains menu. used this cool print format again.
    public static void printIntro()
    {
        System.out.println("\nWelcome to my word search generator!");
        System.out.println("This programs will allow you to generate your own word search puzzle\n");
        System.out.println("Please select and option:");
        System.out.println("""
                              g - Generate a new word search\s\040
                              p - Print out your word search\s
                              s - Show the solution to your word search\s
                              o - Print the puzzle and solution to an output file\s
                              i - Generate a new word search from an input file\s
                              q - Quit the program\s""");
    }
}