// CS 145
// November, 27, 2022
// Assignment 3 - AVL tree

// This class functions as a key for the nodes in my Avl Tree. Might have wanted to move some of this around,
// but I am still figuring out how to use Avl Trees

// start of AvlKey class.
public class AvlKey
{
    // declaring variables
    private String name;
    private int mN;
    private double balance; // account balance for bank members

// constructor  for AvlKey
    public AvlKey(int memberNum, String name)
    {
        // initializing variables
        this.name = name;
        this.mN = memberNum;
        this.balance = 0; // initializes balance to zero
    }

// getBalance method
    public double getBalance()
    {
        return this.balance; // returns member account balance
    }

// method to setBalance, used double for decimal place for dollars.cents. Will come back and add more features to
// this program in the future.
    public void setBalance(double funds)
    {
        this.balance += funds; // adds funds to balance
    }

//  get member number method
    public int getMemberNum()
    {
        return this.mN;
    }
// get name method
    public String getName()
    {
        return this.name; // returns name
    }
}

