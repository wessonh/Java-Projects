import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


// Henry Wesson
// CS 145
// Lab 3 Deck of Cards
// 10/7/2022

// This is the Card class. Its contains a method that constructs the deck in the form of a 52 card stack.
// The createDeck method gets the values of the enum classes Face and Suit and assigns each card its corresponding rank.

// Used enum and swtich case for extra credit.

// start of public
public class Card extends Game
{
    private Suit suit;
    private Face face;
    public int rank;
    private static Stack<Card> cardsDeck = new Stack<>();

    public Card(Suit suit, Face face, int rank)
    {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }
    // creates deck of cards
    static Stack<Card> createDeck()
    {

        for (int i = 1; i <14 ; i++)
        {
            switch (i)
            {
                case 1:
                    for (Face face : Face.values())
                    {
                        cardsDeck.add(new Card(Suit.Hearts, face, i++));
                    }
                    i = 1;
                case 14:
                    for (Face face : Face.values())
                    {
                        cardsDeck.add(new Card(Suit.Clubs, face, i++));
                    }
                    i = 1;
                case 28:
                    for (Face face : Face.values())
                    {
                        cardsDeck.add(new Card(Suit.Diamonds, face, i++));
                    }
                    i = 1;
                case 42:
                    for (Face face : Face.values())
                    {
                        cardsDeck.add(new Card(Suit.Spades, face, i++));
                    }
                    i = 1;
            }
        }
        return cardsDeck;

    }

    public String toString()
    {
        return face + " of " + suit + ": " + rank;
    }
    // method to compare cards for game to decide winner of round
//    public int compareCard(Card enemyCardRank, int winner) {
//        if (this.rank > enemyCardRank.rank) {
//            winner = 1;
//        }
//        if (this.rank < enemyCardRank.rank) {
//            winner = 2;
//        } else {
//            winner = 0;
//        }
//    }
}