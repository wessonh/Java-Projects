// Henry Wesson
// CS 145
// Lab 6 Binary Search Tree Dictionary
// Nov/23/2022

// This is the tree class for my binary search tree. This class contains methods that make do the
// operations of the binary search tree. I accomplished many of these methods by using
// recursive method calls. I think this works correctly. Kind of ran out of time to edit it anymore,
// but I plan on coming back to this after then final. Used

// start ofc BstTree class.
public class BstTree
{
    BstNode root;

// constructors for BstTree    
    BstTree(BstNode root)
    {
        this.root = root;
    }

    BstTree()
    {
        this(null);
    }

    // public add method calls private add method
    public void add(EmployeeInfo info)
    {
        root = add(info, root);
    }

// private BstNode add method. uses if else to determine where to put new employee info.
    private BstNode add(EmployeeInfo info, BstNode treeRoot) 
    {

        if(treeRoot == null) // if root is null add new root
        {
            treeRoot = new BstNode(info);
        }

        else if(treeRoot.getInfo().getEmployeeNum() >= info.getEmployeeNum()) 
        // if the treeRoot number is greater than or equal to the new employee number it move to 
        // the left subtree                                                                   
        {
            treeRoot.left = add(info, treeRoot.left);
        }

        else if(treeRoot.getInfo().getEmployeeNum() < info.getEmployeeNum())
        // if the treeRoot number is less than the new employee number than move it to the right
        {
            treeRoot.right = add(info, treeRoot.right);
        }

        return treeRoot; 
    }

// public getInfo method calls the private getInfo method   
    public EmployeeInfo getInfo(int employeeNum)
    {
        return getInfo(employeeNum, root);
    }
    
// this method gets the employee info that matches the employee number
// uses recursion
    private EmployeeInfo getInfo(int employeeNum, BstNode treeRoot)
    {
        if(treeRoot.getInfo().getEmployeeNum() == employeeNum) //equals employee number 
        {
            return root.getInfo();
        }
        
        else if(treeRoot.getInfo().getEmployeeNum() < employeeNum) // if less checks right subtree
        {
         
          return getInfo(employeeNum, treeRoot.right); // recursive
        }

        else // checks the left subtree
        {
          
            return getInfo(employeeNum, treeRoot.left); // recursive
        }
    }

// public delete method calls the private method
    public void delete(int employeeNum)
    {
    
        root = delete(employeeNum, root);
    }

// private method for delete 
    private BstNode delete(int employeeNum, BstNode treeRoot)
    {

        if(treeRoot == null)
        {
        // if the tree root doesn't already have an employee number
        return null;
        }

        else if(employeeNum < root.getInfo().getEmployeeNum()) // of searched employee is 
        {
            treeRoot.left = delete(employeeNum, treeRoot.left); //recursive call to delete left node
        }

        else if (employeeNum > treeRoot.getInfo().getEmployeeNum())
        {
            treeRoot.right = delete(employeeNum, treeRoot.right); // recursive call for right 
        }

        else // not sure if this part is working correctly. seemed to work in visual studio, but IntelliJ thinks
        // there is a problem of some sort. My program works though, so I'm not sure what I did wrong.
        {

            if(treeRoot.right == null && treeRoot.left == null) // is it has a left node 
            {
                return null;
            }

            else
            {
                assert treeRoot.right != null;
                EmployeeInfo lowest = minimum(treeRoot.right); // calls the minimum method
                BstNode temp = new BstNode(lowest);
                temp.left = treeRoot.left;               
                temp.right = delete(lowest.getEmployeeNum(),treeRoot.right); // recursive
            }
        }
        return root;
    }
    
// this method gets the employee info node that has the lowest employee number in a subtree
    private EmployeeInfo minimum(BstNode treeRoot) // recursive
    {
       if(treeRoot.left == null) // if treeRoot left is null
       {
           return treeRoot.getInfo(); // return treeRoo info
       }
       else
       {
           return minimum(treeRoot.left); // otherwise return minimum. recursive
       } 
    }

// public method for preOrder, calls private preOrder method    
    public void preOrder(String last)
    {
        preOrder(last, root);
    }

// private preOrder method. works for lastName search
    private void preOrder(String last, BstNode treeRoot)
    {

        if(treeRoot != null) // if there is a treeRoot
        {

            if(treeRoot.getInfo().getLast().equals(last)) // if info lastname equals searched last name
            {
                System.out.println(treeRoot); // prints treeRoot
            }

            preOrder(last, treeRoot.left); // recursive
            preOrder(last, treeRoot.right); // recursive
        }
    }

// public InOrder method in order for the search method in main. calls private method
    public void inOrder(int employeeNum)
    {
        inOrder(employeeNum, root);
    }

// private InOrder method. works for employeeNum search
    private void inOrder(int employeeNum, BstNode treeRoot)
    {

        if(treeRoot != null) // if there is a treeRoot
        {
            inOrder(employeeNum, treeRoot.left); // recursive

            if(treeRoot.getInfo().getEmployeeNum() == employeeNum) 
            // if searched employeeNum matches info employeeNum
            {
                System.out.println(treeRoot); // prints treeRoot
            }

        inOrder(employeeNum, treeRoot.right); // recursive
        }
    }

// public inOrder method for last name search
    public void inOrder(String last)
    {
        inOrder(last, root);
    }

// private inOrder method for last name search
    private void inOrder(String last, BstNode treeRoot)
    {

        if(treeRoot != null) // if there is a treeRoot
        {
            inOrder(last, treeRoot.left);  // recursive

            if(root.getInfo().getLast().equals(last)) // if searched last name equals info lastName
            {
                System.out.println(treeRoot); // print treeRoot
            }
            inOrder(last, treeRoot.right); // recursive
        }
    }
    
// public method for postOrder. used in last name search. calls private method    
    public void postOrder(String last)
    {
        postOrder(last, root);
    }
    
// private method for postOrder. User in last name search.
    private void postOrder(String last, BstNode treeRoot)
    {
    
        if(treeRoot != null) // if there is a treeRoot
        {
            postOrder(last, treeRoot.left); // recursive
            postOrder(last, treeRoot.right); // recursive

            if(treeRoot.getInfo().getLast().equals(last)) // if info last name equals searched last name
            {
                System.out.println(treeRoot); // print treeRoot
            }
        }
    }
} // end of BstTree class

