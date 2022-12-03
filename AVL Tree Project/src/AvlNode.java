// Henry Wesson
// CS 145
// November, 27, 2022
// Assignment 3 - AVL tree

// This class contains the AvlNode which store the member Info for each node in the Avl Tree.
// Kind of messy but I didn't end up having time to fix it. Going to work on this more after the final.
public class AvlNode
{
    // declaring variables

    private int level; // represents level in Avl tree
    private AvlNode left;
    private AvlNode right;
    private final AvlKey key; // seems like I need to implement a key based off of the resources I saw

    // constructor for AvlNode
    public AvlNode(int mN, String name)
    {
        // initializing variables
        this.key = new AvlKey(mN, name);
        this.level = 1; // set initial height to 1
        this.left = null;
        this.right = null;
    }

    // mutators VVVV

    // setLeft method
    public void setLeft(AvlNode memberInfo)
    {
        left = memberInfo;
    }

    // setRight method
    public void setRight(AvlNode memberInfo)
    {
        this.right = memberInfo;
    }

    // setBalance method
    public void setBalance(double money)
    {
        this.key.setBalance(money);
    }

    // setHeight method. ended up using Math.max to do this
    public void setLevel()
    {
        this.level = 1 + Math.max(this.getLevel(this.getLeft()),this.getLevel(this.getRight()));
    }


    // accessors VVVV

    public AvlNode getLeft()
    {
        return this.left;
    }

    public AvlNode getRight()
    {
        return this.right;
    }

 // getMemberNum method
    public int getMemberNum() // look at this ..........
    {
        return this.key.getMemberNum();
    }

// getLevel method
    public int getLevel(AvlNode memberInfo)
    {
        if(memberInfo == null)  // if node is empty
        {
            return 0; // return 0 for height
        }
        return memberInfo.level; // return height
    }

// getBalance method
    public double getBalance()
    {
        return this.key.getBalance(); // returns balance
    }

// getName method
    public String getName()
    {
        return this.key.getName();
    }

} //end of class Node

