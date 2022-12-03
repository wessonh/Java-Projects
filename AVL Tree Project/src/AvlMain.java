// Henry Wesson
// CS 145
// November, 27, 2022
// Assignment 3 - AVL tree

// This program utilizes and Avl Tree to keep track on members of a bank and their account information. As nodes
// are removed or added to the tree, the tree is able to balance itself. I also utilize a queue in my Avl Tree method
// for the levelOrder method. This program was pretty tricky because I was not very familiar with Avl trees. After
// some research this is what I put together, but I still want to improve this a lot, so I will work on it on my own
// after then quarter.

// I kind of ran out of time to add features to this. I wanted to add some user error proofing features, but I
// will have to do this on my own after the final. I plan on adding try catch to catch all exceptions soon.

// IMPORTANT, you must first sign in to an account before you can access funds. Not sure if this was the best use for an
// AVL tree, but I did end up learning a lot by doing this on my own. Would have liked to do something with the
// ordering, but I didn't end up having time before the final.

// The view order feature in the menu was an after though that I threw in. I know it doesn't make sense in a
// user banking application, but I wanted to show off printing the pre, in, post, and level order of the tree
// I will try to find a better was to implement this in the program, so it makes more sense. 


import java.util.*;

// start of the AvlMain class
public class AvlMain
{
    private static AvlTree bank;

    // constructor for AvlMain

// main method, has switch case menu for choosing options. Calls other methods from program
    public static void main(String[] args)
    {
        int num = 0;
        int bal = 0;
        int with;
        boolean run = true;



        bank = new AvlTree();

        Scanner keyboard = new Scanner(System.in);
        do // do while for menu
        {
            System.out.println("\nGreetings! Welcome to Henry's Mobile Banking Program!");
            System.out.println("\n\nPlease choose an option: \n");
            System.out.println("""
                                1 - Create Account\s
                                2 - Sign Into Account\s\s
                                3 - View Balance\s
                                4 - Deposit\s
                                5 - Withdraw\s
                                6 - Delete Account\s
                                7 - View Order\s  
                                0 - Exit\s""");

            int choice = keyboard.nextInt();
            System.out.println();

            switch (choice)
            {
                case 1 ->
                { // create an account
                    System.out.println("Please enter your name: \n");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("\nPlease enter your member number:");
                    num = keyboard.nextInt();
                    create(num, name);
                    System.out.println("\nAccount successfully created! ");
                }
                case 2 ->
                { // sign-in to account to withdraw, deposit, delete
                    System.out.println("Please enter your member number: ");
                    int i = 0;

                    do
                    {
                        i++;
                        bal = keyboard.nextInt();

                        if (bank.search(bal) == null)
                        {
                            System.out.println("Account not found, please try again");
                        }
                    }
                    while (bank.search(bal) == null && i < 5);

                    if (bank.search(bal) == null) // if null
                    {
                        System.out.println("Empty");
                        return;
                    }
                }
                case 3 ->
                { // shows user the current balance
                    System.out.println("Member: " + getName(num));
                    System.out.println("Current Balance: " + getBalance(num));
                }
                case 4 ->
                { // sets balance for account
                    System.out.println("Please enter an amount to deposit:");
                    bal = keyboard.nextInt();
                    setBalance(num, bal);
                    System.out.println("New Balance: " + getBalance(num));
                }
                case 5 ->
                { // lets user withdraw money, just subtracts from balance
                    System.out.println("Please enter an amount to withdraw:");
                    with = keyboard.nextInt();
                    setBalance(num, -with);
                    System.out.println("New Balance: " + getBalance(bal));
                }
                case 6 ->
                {
                    del(bal);
                    System.out.println("\nAccount Deleted! ");
                    return;
                }
                case 7 -> // this doesn;t really make sense with the program, but I wanted to show off the
                // pre, in ,post, and level order methods I made in the AvlTree class. I will find a way
                // to implement this that makes more sense, but I wanted to prove I could do it for my own learning.
                {
                    System.out.println("Please enter an member number");
                    int memberNum = keyboard.nextInt();

                    System.out.println("Which order would you like to view");
                    System.out.println("""
                                        1 - Pre Order\s
                                        2 - In Order\s
                                        3 - Post Order\s
                                        4 - Level Order\s""");
                    try
                    {
                        int option = Integer.parseInt(keyboard.next());

                        switch (option) // switch case to make menu for order
                        {
                            case 1 -> bank.preOrder(memberNum);
                            case 2 -> bank.inOrder(memberNum);
                            case 3 -> bank.postOrder(memberNum);
                            case 4 -> bank.levelOrder(memberNum);
                            default -> System.out.println("Please enter a proper command!");
                        }
                    }
                    catch (Exception e) // catches exception
                    {
                        System.out.println("Please enter a proper command!");
                    }
                }
                case 0 ->
                {
                    run = false;
                    System.out.println("\nQuitting... Goodbye!");
                }
                default -> throw new IllegalStateException("Invalid command!");
            }
        }
        while(run);
    } // end main method

// create account method
    private static void create(int ID, String name)
    {
        bank.add(ID, name);
    }

// delete account method
    private static void del(int mN)
    {
        bank.delete(mN);
    }

// get balance method
    private static double getBalance(int mN)
    {
        return bank.search(mN).getBalance();
    }

// getName method, gets name from search
    private static String getName(int mN)
    {
        return bank.search(mN).getName();
    }

// setBalance method, calls method from other
    private static void setBalance(int ID, double num)
    {
        bank.search(ID).setBalance(num);
    }
} // end AvlMain class
