// Henry Wesson
// CS 145

import java.util.*;
import java.io.*;

// start of WordSearch Class, this contains the methods that generate the word search. It does this with 2 different arrays
// and it also uses a third to generate the solution for the user to view. The program is able to accommodate word
// length when designing the grid. It is also able to output to a file.
public class WordSearch
{
    // variables
    // declaring the arrays

    private String[] words;
    private char[][] wordGrid;
    private boolean[][] wordSolution;

    // this method generates a word search from the String array using for loops and then calls the randomLetters method
    // to finish it.
    public void generate(String[] w)
    {

        for(int i = 0 ; i < w.length ; i++)
        {
            w[i] = w[i].toLowerCase();
        }

        this.words = w; // make this.words again if broken
        char[][] wordLetters = setGrid();

        for(int i = 0 ; i < wordLetters.length ; i++)
        {
            addWord(wordLetters, i); // calls placeWord
        }
        randomLetters(); // calls randomLetters to finish the wordGrid
    }

// to string method
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (char[] chars : wordGrid) {
            for (char aChar : chars) {
                result.append(" ").append(aChar).append(" ");
            }
            result.append("\n");
        }
        return result.toString(); // returns the result
    }

// This method add the words to the word search grid. It will also randomly determine if the word is going to be added
// vertically, horizontally, or diagonally. I realized I didn't add the feature to make the words appear backwards
// which was disappointing. I had some trouble figuring out how to do that. I am still going to mess around with this\
// and try to figure it out on my own. This program ended up being pretty difficult for me.  I think I also should
// have chopped this method up into multiple smaller methods but didn't have to time to fix it. Will get to this later.
    private void addWord(char[][] wordChars, int place)
    {
        Random r = new Random();
        int direction = r.nextInt(3);
        int[] position = {0,0};

        if(direction == 0) // if direction is 0 adds word horizontally on grid.
        {
            boolean added = false;
            int inputs = 0;

            while(!added && inputs < 100) // limits attempts t0 100
            {
                position[0] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                position[1] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                added = true;

                for(int u = 0 ; u < wordChars[place].length ; u++)
                {
                    if(wordGrid[position[0] + u][position[1]] != '\u0000' && wordGrid[position[0] + u][position[1]] != wordChars[place][u])
                    {
                        added = false;
                        break;
                    }
                }
                inputs++;
            }
            if(added)
            {

                for(int x = 0 ; x < wordChars[place].length ; x++)
                {
                    wordGrid[position[0]][position[1]] = wordChars[place][x];
                    wordSolution[position[0]][position[1]] = true;
                    position[0]++;
                }
            }
        }
        else if(direction == 1) // otherwise word adds vertically
        {
            boolean added = false;
            int inputs = 0;

            while(!added && inputs < 100)
            {
                position[0] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                position[1] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                added = true;

                for(int u = 0 ; u < wordChars[place].length ; u++)
                {
                    if(wordGrid[position[0]][position[1] + u] != '\u0000' && wordGrid[position[0]][position[1] + u] != wordChars[place][u])
                    {
                        added = false;
                        break;
                    }
                }
                inputs++;
            }
            if(added)
            {

                for(int x = 0 ; x < wordChars[place].length ; x++)
                {
                    wordGrid[position[0]][position[1]] = wordChars[place][x];
                    wordSolution[position[0]][position[1]] = true;
                    position[1]++;
                }
            }
        }
        else {
            boolean added = false;
            int inputs = 0;
            while(!added && inputs < 100)
            {
                position[0] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                position[1] = r.nextInt((wordGrid.length-1) - wordChars[place].length);
                added = true;

                for(int u = 0 ; u < wordChars[place].length ; u++)
                {
                    if(wordGrid[position[0] + u][position[1] + u] != '\u0000' && wordGrid[position[0] + u][position[1] + u] != wordChars[place][u])
                    {
                        added = false;
                        break;
                    }
                }
                inputs++;
            }
            if(added)
            {

                for(int x = 0 ; x < wordChars[place].length ; x++)
                {
                    wordGrid[position[0]][position[1]] = wordChars[place][x];
                    wordSolution[position[0]][position[1]] = true;
                    position[1]++;
                    position[0]++;
                }
            } // end if
        } // end else if diagonal
    }

// this method makes a char array and makes sure the wordGird can accommodate the max length of words
// in the array. Could add more functionality, will toy around with this in the future.
    private char[][] setGrid()
    {
        char[][] letters = new char[words.length][];

        int maxLength = 8;

        for(int i = 0 ; i < words.length ; i++)
        {
            letters[i] = words[i].toCharArray();
            if(letters[i].length > maxLength)
            {
                maxLength = letters[i].length;
            }
        }

        if(words.length > maxLength) // cuts word off at max length
        {
            maxLength = words.length;
        }
        this.wordGrid = new char[maxLength + 4][maxLength + 4];
        this.wordSolution = new boolean[maxLength + 4][maxLength + 4];
        return letters;
    }
    // returns the solution to the word search to print as a visual representation
    public String toSolution()
    {
        StringBuilder solution = new StringBuilder();

        for(int i = 0 ; i < wordGrid.length ; i++)
        {
            for(int x = 0 ; x < wordGrid[i].length ; x++)
            {
                if(wordSolution[i][x]) // if there is a word show word
                {
                    solution.append(" ").append(wordGrid[i][x]).append(" ");
                }
                else // otherwise make * fill the void spaces. maybe should have chose a different symbol,
                // this one is a little hard to see but it was better than others I tried.
                {
                    solution.append(" - ");
                }
            } // end nested for loop
            solution.append("\n"); // adds new line to solution
        } // end for loop

        return solution.toString(); // returns the solution
    }

// This method fills the wordGrid with random letters in the leftover space
    private void randomLetters()
    {
        for(int i = 0 ; i < wordGrid.length ; i++)
        {
            for(int x = 0 ; x < wordGrid[i].length ; x++)
            {
                Random r = new Random();

                if(wordGrid[i][x] == '\u0000')
                {
                    wordGrid[i][x] = (char)(r.nextInt(26)+97);
                }
            } // end nested for loop
        } // end for loop
    }

// added a make file method. uses PrintStream to print a word search and its solution to a file.
    public void saveFile (File wsFile) throws FileNotFoundException
    {
        PrintStream fileOut = new PrintStream(wsFile);
        fileOut.println(this);
        fileOut.println(this.toSolution());
    }
} // end of wordSearch class
