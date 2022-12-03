// Henry Wesson
// CS 145
// Lab 5 - Towers of Hanoi
// November, 10, 2022

// This is the main class file for my Towers of Hanoi program. This program is able to solve the towers of hanoi puzzle.
// It uses Stacks to represent the discs on each peg and it uses a recursive method call to perform the operations to
// complete the puzzle in the correct(fewest) amount of moves. The user is also able to select the amount of discs they
// wish to play with from up to 10 discs

import java.util.*;

public class HWTowersOfHanoi
{

    // used protected for these stacks. Not sure if this was the right thing to do or not. I think I could have also
    // reorganized this program a bit but I didn't end up getting around to it. I will add more features to this over
    // time for fun.
    protected static Stack<Boolean> peg1;
    protected static Stack<Boolean> peg2;
    protected static Stack<Boolean> peg3;

    // start of main method. Calls other methods to solve the towers of hanoi puzzle. uses for loop.
    public static void main(String[] args)
    {
        // initializing stacks
        peg1 = new Stack<>();
        peg2 = new Stack<>();
        peg3 = new Stack<>();

        int disc = HWMenu.menu();

        for(int i = disc; i > 0; i--)
        {
            peg1.push(true);
        }
        // sets the order
        HWPeg origin = HWPeg.A;
        HWPeg move = HWPeg.B;
        HWPeg target = HWPeg.C;
        HWStep.step(disc, origin, move, target); //calls the step method
        //prints amounts of discs on each peg as visual representation
        System.out.println(peg1.size() + " - " + peg2.size() + " - " + peg3.size());
        System.out.println("\nThank you for running the Towers of Hanoi!");
        // Thought about adding a pay again feature, could have done this but ran out of time. I will definitely add
        // this later on.

    } // end main method
} // end TowersOfHanoi class
