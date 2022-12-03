import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Random; // decided to use Collections instead.
import java.util.Stack;
import java.util.Collections; // ended up using this because it can shuffle a stack. I didn't end up using an array.

// Bonus points: I used enum with my suit and face classes and case and switch in my createDeck method in my Card class.

// this the game method that contains the main method which calls the other methods and runs the game. This program
// simulates the game War. The gameDeck that is made in the Card class is shuffled and made into two queues. The players
// then draw cards and compare their rank, the highest putting both cards on the bottom of their deck. In result of
// a tie, the players will put two cards into a stack and then play a round. they will repeat this if a tie, otherwise
// the winner takes the stack. Fist player to run out of cards loses.

// I have two bugs where when the thisIsWar method happens the program crashes or when a Player runs out of cards and
// another round happens the game doesn't end properly and crashes. I tried to fix these for a long time but I
// couldn't end up figuring it out. I am going to work on this on my own time and fix it for personal knowledge.
// I had fun with this assignment and want to make more card games.

public class Game
{
    static Stack <Card> gameDeck = new Stack<>(); // main game deck queues are taken from
    static Queue <Card> player1Deck = new LinkedList<>(); // player1 15 cards
    static Queue <Card> player2Deck = new LinkedList<>(); // player2 15 cards

// main method to run game, make player decks, and call other methods
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String namePlayer1;
        String namePlayer2;

        gameDeck = Card.createDeck(); //creates the main deck for the game
//        System.out.println(gameDeck); // prints for testing

        Collections.shuffle(gameDeck); // used this instead because I learned it was specifically for lists and stacks.
        System.out.println("Welcome, let's play War!"); //prompt to start and enter name player 1

        System.out.println(gameDeck); //remove

        System.out.println("Player One: Please enter name"); // prompts for name and assigns it to player1
        namePlayer1 = keyboard.nextLine();

        for(int i = 0; i<15; i++) // for loop to make 15 card deck for player1
        {
            player1Deck.add(gameDeck.remove(0));
        }

//         System.out.println(player1Deck); // prints deck for testing

        System.out.println("Player Two: Please enter name"); // prompt player 2 enter name.
                                                             // don't know if player2 name is even necessary
        namePlayer2 = keyboard.nextLine();

        for(int i = 0; i<15; i++) // for loop to make 15 card deck for player 2
        {
            player2Deck.add(gameDeck.remove(0));
        }

        System.out.println();
//         System.out.println(player2Deck); // prints for testing

        Card drawPlayer1 = player1Deck.peek(); // sets different players card to card on top of each deck
        Card drawPlayer2 = player2Deck.peek();

        System.out.println("\nBegin!\n");
        playGame(namePlayer1, namePlayer2, drawPlayer1, drawPlayer2, player1Deck, player2Deck, keyboard);
    }

    // start of the playGame method. determines winner, otherwise continues game. while the player decks is not empty
    // continue the game.
    public static void playGame(String namePlayer1, String namePlayer2, Card drawPlayer1, Card drawPlayer2
            , Queue<Card> player1Deck, Queue<Card> player2Deck, Scanner keyboard)
    {
        if (player1Deck.isEmpty())
        {
            System.out.println(namePlayer2 + " is the winner!!!");
        }
        else if (player2Deck.isEmpty())
        {
            System.out.println(namePlayer1 + " is the winner!!!");
        }
        else
        {
            while (!player1Deck.isEmpty() || !player2Deck.isEmpty()) // mess with this
            {
                Draw(keyboard);
                roundStart(namePlayer1, namePlayer2, drawPlayer1, drawPlayer2);
                gameRound(namePlayer1, namePlayer2, drawPlayer1, drawPlayer2);
                System.out.println(player1Deck);
                System.out.println(player2Deck);
            }
        }

    }
    // could something be going wrong here. Is there a problem with me redefining variable here?
    private static void gameRound(String namePlayer1, String namePlayer2, Card drawPlayer1, Card drawPlayer2)
    {
        drawPlayer1 = player1Deck.peek(); // sets drawPlayer1 to peek
        drawPlayer2 = player2Deck.peek(); // sets drawPlayer2 to peek  game doesn't work correctly if I remove this

        if (drawPlayer1.rank > drawPlayer2.rank) // this if else statement compares the cards
        {
            roundWin1(namePlayer1);
        }
        else if (drawPlayer2.rank > drawPlayer1.rank)
        {
            roundWin2(namePlayer2);
        }
        else
        {
            System.out.println("\nThis is WAR!!!");
            thisIsWar(namePlayer1, namePlayer2, drawPlayer1, drawPlayer2); // supposed to call this is WAR, crashes
        }
    }
// I am having a problem with this method.
    private static void thisIsWar(String namePlayer1, String namePlayer2, Card drawPlayer1, Card drawPlayer2)
    {
        drawPlayer1 = player1Deck.peek();
        drawPlayer2 = player2Deck.peek();
        boolean tie = false;
        Stack<Card> thisIsWar = new Stack<>();

        // do while is supposed to continue war as long as boolean tie is false. This method keeps breaking when
        // it tries to run thisIsWar. I wasn't able to figure out how to fix this in time. I will contine working
        // on this for personal knowledge. I plan on taking this to the tutoring center.
        do
        {
            if (player1Deck.size() < 2);
            {
                gameOver(player1Deck, player2Deck);
            }
            if (player2Deck.size() < 2);
            {
                gameOver(player2Deck, player1Deck);
            }
            for(int i = 0; i < 2; i++)
            {
                thisIsWar.push(player1Deck.remove());
                thisIsWar.push(player2Deck.remove());
            }
            roundStart(namePlayer1, namePlayer2, drawPlayer1, drawPlayer2);

            if (drawPlayer1.rank > drawPlayer2.rank) // if player1 wins war
            {
                while (!thisIsWar.isEmpty()) // while war pile isn't empty add to player 1
                {
                    player1Deck.addAll(thisIsWar); // give war pile to player1
                }
                System.out.println();
                System.out.println(namePlayer1 + " wins the War!\n");
            }
            if(drawPlayer1.rank < drawPlayer2.rank)  // if player2 wins war
            {
                while (!thisIsWar.isEmpty())
                {
                    player2Deck.addAll(thisIsWar);
                }
                System.out.println(namePlayer2 + " wins the War!");
            }
            else
            {
                tie = true;
            }
        }
        while (tie);
    }

    // method to start round
    private static void roundStart(String namePlayer1, String namePlayer2, Card drawPlayer1, Card drawPlayer2) {
        drawPlayer1 = player1Deck.peek();
        drawPlayer2 = player2Deck.peek();

        System.out.println();
        try // thought this would stop the error but it didn't end up working
        {
            System.out.println(namePlayer1 + ": " + drawPlayer1.toString() + "\n\t\t|VS|\n"
                    + namePlayer2 + ": " + drawPlayer2.toString());
        }
        catch (Exception e)
        {
            System.out.println("Out of Cards!"); // error when on player runs out of cards. I wasn't able to fix
        }                                        // this in time but I am still going to work on correcting this.
    }
    private static void roundWin1(String namePlayer1) // method to give player 1 cards if they win round
    {
        player1Deck.add(player1Deck.remove()); // puts player1 top card on bottom
        player1Deck.add(player2Deck.remove()); // takes opponent card and puts on bottom
        System.out.println();
        System.out.println(namePlayer1 + " wins the turn!\n");
    }
    private static void roundWin2(String namePlayer2) // method to give palyer 2 cards if they win round
    {
        player2Deck.add(player2Deck.remove()); // puts player1 top card on bottom
        player2Deck.add(player1Deck.remove()); // takes opponent card and puts on bottom
        System.out.println();
        System.out.println(namePlayer2 + " wins the turn!\n");
    }
    private static void gameOver(Queue<Card> lose, Queue<Card> win) // method for in player can't draw during war
    {
        while (!lose.isEmpty())
        {
            win.add(lose.remove());
        }
    }
    // method to press enter to continue
    public static void Draw(Scanner keyboard)
    {
        System.out.println("\nPress enter to Draw!");
        keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }

}