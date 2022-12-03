// Henry Wesson
// CS 145
// November 1, 2022

// This class contains the methods responsible for the menu functionality in the main method. Each of these are
// called in the switch case i made in the main.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class WordSearchMenu
{
    // generate words search method prompts user to input words to make a word search.
    public static void generate(Scanner keyboard, WordSearch search)
    {
        System.out.println("Enter words line by line until you are finished at which point type a single \"q\"");
        String word = keyboard.next();
        ArrayList<String> wordArray = new ArrayList<>();
        do
        {
            wordArray.add(word);
            word = keyboard.next();
        }
        while (!word.equals("q") && !word.equals("Q")); // not case-sensitive
        {
            String[] words = new String[wordArray.size()];
            wordArray.toArray(words);
            search.generate(words);
        }
    }
    // method lets you view the search you made
    public static void view(WordSearch search)
    {
        try // try catch for if no word search exists
        {
            print(search);
        }
        catch (Exception e)
        {
            System.out.println("First you must generate a word search!");
        }
    }
    // Method to print word search
    public static void print(WordSearch wSearch)
    {
        System.out.println(wSearch);
    }
    // solution method
    public static void solution(WordSearch search)
    {
        try // try catch for if no word search is generated
        {
            viewSolution(search);
        }
        catch (Exception e)
        {
            System.out.println("First you must generate a word search!\n");
        }
    }

    // Method to print solution to word search
    public static void viewSolution(WordSearch game)
    {
        System.out.println(game.toSolution());
    }

    public static void output(Scanner keyboard, WordSearch search)
    {
        try
        {
            System.out.println("Name the output file you would like to save.\n");
            String path = keyboard.next();
            search.saveFile(new File(path));
        }
        catch (Exception e)
        {
            System.out.println("First you must generate a word search!\n");
        }
    }
    // extra credit method for file input
    public static void input(Scanner keyboard, WordSearch search)
    {
        System.out.println("Please enter the path to the file you would like to input from.\n");
        String path = keyboard.next();

        try // try catch to make sure file name is valid
        {
            Scanner fileInput = new Scanner(new File(path));
            ArrayList<String> wordArray = new ArrayList<>();
            while (fileInput.hasNext())
            {
                wordArray.add(fileInput.next());
            }
            if (wordArray.size() > 0)
            {
                String[] words = new String[wordArray.size()];
                wordArray.toArray(words);
                search.generate(words);
            }
            else
            {
                System.out.println("The file contains no words.\n");
            }
        }
        catch (FileNotFoundException e) // catch the exception
        {
            System.out.println("Please select a valid file!\n");
        }
    }
} // end WordSearchMenu class

