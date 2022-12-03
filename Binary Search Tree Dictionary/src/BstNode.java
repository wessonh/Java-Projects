// Henry Wesson
// CS 145
// Lab 6 Binary Search Tree Dictionary
// Nov/23/2022

// This class is for the Binary Search Tree node. It stores the employee info for each node in the tree.

//start of BstNode class
public class BstNode
{
    // declaring variables
    EmployeeInfo info;
    BstNode left;
    BstNode right;

// constructors for BstNode
    public BstNode(EmployeeInfo info)
    {
        this(info,null, null);
    }

    public BstNode(EmployeeInfo info, BstNode left, BstNode right)
    {
        this.info = info;
        this.left = left;
        this.right = right;
    }
// returns employee info
    public EmployeeInfo getInfo()
    {
        return info;
    }

// toString method for printing the employee info from the node. Not sure if this should go here or not.
    public String toString()
    {
        return "\nNo: " + info.getEmployeeNum() + "\n"
        + "Name: " + info.getFirst() + " " + info.getLast() + "\n"
        + "Address: " + info.getAddress() +"\n"
        + "City: " + info.getCity() + "\n"
        + "State: " + info.getState() + "\n"
        + "Zip Code: " + info.getZip() + "\n"
        + "Phone Number: " + info.getPhoneNum() + "\n"
        + "Email: " + info.getEmail() + "\n";
    } 
} // end BstNode class

