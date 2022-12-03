// Lab 6 Binary Search Tree Dictionary
// Nov/23/2022

// This program functions as a Binary Search Tree dictionary that is able to keep track of employee information and orders them by
// a member number. The menu will let the user add a new employee info node to the binary search tree, delete a node,
// search for a node which will allow the user to post a pre-order, in order, or post order. and to exit.

import java.util.*;

public class BstMain
{
// start of the main method. Uses a switch case menu to call the other methods of the program

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        BstTree directory = new BstTree();
        boolean run = true;
        
        do
        {   
            instructions(); // calls instructions method

            try // start of try catch to catch exceptions 
            {
                System.out.println("\nPlease choose an option:\n");
                int choice = Integer.parseInt(keyboard.next());

                switch (choice)
                {
                    case 1 ->// add
                            directory.add(newEmployee(keyboard));
                    case 2 -> // delete
                            deleteEmployee(keyboard, directory);
                    case 3 ->// search
                            search(directory, keyboard);
                    case 4 -> // edit
                            editEmployee(keyboard, directory);
                    case 0 ->
                    { // exit
                        run = false;
                        System.out.println("\nQuitting...\n\nGoodbye!\n");
                    }
                    default -> System.out.println("\nPlease enter a proper command!");
                }
            }
            catch(Exception e)
            {
                System.out.println("\nPlease enter a number!");
                break;
            }
               
        }
        while(run);
    }
    
// this method prints an introduction to the user and explains the menu
    public static void instructions()
    {
        System.out.println("\nWelcome to the Epic Awesome Co. Employee Dictionary!\n"); // fix
        System.out.println("""
                            1 - Add new entry\s
                            2 - Delete entry\s
                            3 - Search dictionary\s
                            4 - Edit entry\s
                            0 - Exit""");
    }

// This is the method to enter new employee info 
    public static EmployeeInfo newEmployee(Scanner keyboard)
    {
        String yes;
        EmployeeInfo info = new EmployeeInfo();
        
        do // do while to reset if input is invalid at confirm
        {
            System.out.println("\nPlease enter a member number: ");
            info.setEmployeeNum(keyboard.nextInt());

            System.out.println("Please enter a first name: ");
            info.setFirst(keyboard.next());

            System.out.println("Please enter a last name: ");
            info.setLast(keyboard.next());

            System.out.println("Please enter a street address: ");
            keyboard.nextLine();
            info.setAddress(keyboard.nextLine());

            System.out.println("Please enter a city: ");
            info.setCity(keyboard.next());

            System.out.println("Please enter a state: ");
            info.setState(keyboard.next());

            System.out.println("Please enter a zipcode: ");
            info.setZip(keyboard.nextInt());

            System.out.println("Please enter a phone number: ");
            info.setPhoneNum(keyboard.next());

            System.out.println("Please enter an email: ");
            info.setEmail(keyboard.next());

            System.out.println("\n Confirm employee? Press y or n");

            yes = keyboard.next().toLowerCase();

            while(!yes.equals("y") && !yes.equals("n")) // while input isn't valid
            {
                System.out.println("Please enter a proper command! "); // print message
                yes = keyboard.next().toLowerCase();
            }
        } 
        while(!yes.equals("y")); // while to loop menu while confirm doesn't equal yes

    return info; // returns the employee info
    }

// start of search method for menu.    
    public static void search(BstTree directory, Scanner keyboard)
    {
        // this prompts the user to search by EmployeeNum or last name
        System.out.println("\nPlease choose an option");
        System.out.println("""
                           1 - Employee Number\s
                           2 - Last Name\s""");

        int choice = Integer.parseInt(keyboard.next());

        while(choice != 1 && choice != 2 ) // while choice isn't one of the options...
        {
            System.out.println("Invalid command!"); // display error message
            choice = Integer.parseInt(keyboard.next());
        }
    
        if(choice == 1) // if choice is 1 
        {
            //prompt user for member number, the print results
            System.out.println("Please enter the employee number: ");
            int employeeNum = keyboard.nextInt();
            directory.inOrder(employeeNum);
        } 
        else
        {
            //prompt user to search by last name
            System.out.println("Please enter the last name: ");
            String lastName = keyboard.next();

            //prompt user for the order of the search
            System.out.println("Please choose an order for the search");
            System.out.println("""
                               1 - Pre Order\s
                               2 - In Order\s
                               3 - Post Order\s""");

                               
            //try catch to catch bad input          
            try 
            {
                choice = Integer.parseInt(keyboard.next());

                switch (choice) // switch case to make menu for order
                {
                    case 1 -> directory.preOrder(lastName);
                    case 2 -> directory.inOrder(lastName);
                    case 3 -> directory.postOrder(lastName);
                    default -> System.out.println("Please enter a proper command!");
                }
            } 
            catch (Exception e) // catches exception
            {
                System.out.println("Please enter a proper command!");
            }
        }
    } 
// deleteEmployee method.   
    public static void deleteEmployee(Scanner keyboard, BstTree directory)
    {
        int employeeNum;

        //prompts user for employee number
        System.out.println("Please enter an employee number: ");
        employeeNum = keyboard.nextInt();
    
        //print out employee info
        System.out.println();
        directory.inOrder(employeeNum);
             
        directory.delete(employeeNum);
        System.out.println("Employee Deleted");
    }

// edit employee method. This lets the user overwrite an existing employee info node with new data    
    public static void editEmployee(Scanner keyboard, BstTree directory)
    {
        String confirm;
        int employeeNum;
    
        System.out.println("\nPlease enter the number of the employee you'd like to edit");
        employeeNum = keyboard.nextInt();
        EmployeeInfo info = directory.getInfo(employeeNum);

        do
        {
            System.out.println("\nPlease enter a new member number: ");
            info.setEmployeeNum(keyboard.nextInt());

            System.out.println("Please enter a new first name: ");
            info.setFirst(keyboard.next());

            System.out.println("Please enter a new last name: ");
            info.setLast(keyboard.next());

            System.out.println("Please enter a  new street address: ");
            keyboard.nextLine();
            info.setAddress(keyboard.nextLine());

            System.out.println("Please enter a new city: ");
            info.setCity(keyboard.next());

            System.out.println("Please enter a new state: ");
            info.setState(keyboard.next());

            System.out.println("Please enter a new zipcode: ");
            info.setZip(keyboard.nextInt());

            System.out.println("Please enter a new phone number: ");
            info.setPhoneNum(keyboard.next());

            System.out.println("Please enter a new email: ");
            info.setEmail(keyboard.next());

            System.out.println("\n Confirm changes to employee? Press y or n");

            confirm = keyboard.next().toLowerCase();
        
            while(!confirm.equals("y") && !confirm.equals("n")) // while input isn't valid
            {
                System.out.println("Please enter a proper command! "); // print message
                confirm = keyboard.next().toLowerCase();
            }
        } 
        while(!confirm.equals("y")); // while to loop menu while confirm doesn't equal yes

    directory.delete(info.getEmployeeNum()); // removes old info
    directory.add(info); // adds new info in its place
    System.out.println("Employee Successfully updated!");

    }

}
    
    
    
