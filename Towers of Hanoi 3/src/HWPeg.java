// Henry Wesson
// CS 145
// Lab 5 - Towers of Hanoi
// November, 10, 2022

import java.util.Stack;

// I was inspired to try and use an enum here. I am trying to get better at implementing things like this.
// I feel like it works here but I could have organized this program a bit better. This class represents the peg and
// discStack, includes methods for push and pop to move the discs
public enum HWPeg
{
    // assigning the values
    A(HWTowersOfHanoi.peg1), B(HWTowersOfHanoi.peg2), C(HWTowersOfHanoi.peg3);

    private final Stack<Boolean> discStack; // creating discStack stack

    // initializes the disc stack
    HWPeg(Stack<Boolean> discStack)
    {
        this.discStack = discStack;
    }

    // boolean to pop disc off of peg
    Boolean discPop()
    {
        return discStack.pop();
    }
    // method to push disc onto stack
    public void discPush(boolean pop)
    {
            discStack.push(pop);
    }
} // end HWPeg enum