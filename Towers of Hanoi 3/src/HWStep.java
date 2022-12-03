// Henry Wesson
// CS 145
// Lab 5 - Towers of Hanoi
// November, 10, 2022

// this class contains the method that uses recursive calls to complete the Towers of Hanoi puzzle. It will have a base
// case of one disc and the else statement will cycle through the correct moves from the correct pegs to complete the
// puzzle in the correct amount of turns 4 discs should take 15 turns to complete.

 public class HWStep
{
    static void step(int disc, HWPeg origin, HWPeg move, HWPeg target)
    {
        if (disc == 1) // base case, one disc.
        {
            System.out.println(HWTowersOfHanoi.peg1.size() + " - " + HWTowersOfHanoi.peg2.size() + " - "
                    + HWTowersOfHanoi.peg3.size());
            System.out.println("Disc " + disc + ": " + origin + " to " + target);
            System.out.println();

            target.discPush(origin.discPop());
        } // end if
        else// otherwise...
        {
            //recursively calls move
            // order changes of method calls to perform step of puzzle
            step(disc - 1, origin, target, move);

            System.out.println(HWTowersOfHanoi.peg1.size() + " - " + HWTowersOfHanoi.peg2.size() + " - "
                    + HWTowersOfHanoi.peg3.size());
            System.out.println("Disc " + disc + ": " + origin + " to " + target);
            System.out.println();

            target.discPush(origin.discPop());
            // recursively calls move
            // changes the order of method calls again
            step(disc - 1, move, origin, target);
        } // end else
    } // end step method
} // end step class