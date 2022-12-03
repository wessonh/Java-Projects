import java.util.*;

//  Henry Wesson
//  CS - 145
//  Assignment 1 - Phonebook
//  October, 16, 2022

// This program uses a linked list and node to make a phonebook. Contacts are sorted by alphabetical order of last name.
// Each node contains the contact's name (first and last), phone number, address, and city. The program has an menu
// that allows the user to add a contact to phonebook, delete a contact, view all contacts, search for their name,
// address, or phone number.

// add search by address to this program


// start of phoneBook class
public class HWPhoneBook
{
    public static void main(String[] args)
    {
        HWList newList = new HWList();
        Scanner keyboard = new Scanner(System.in);
        // variables
        int choice;
        boolean done = false;
        // adds the test contacts to phonebook
        // this wouldn't work with my edit features, thought
        // these nodes were empty even though they weren't
        //testContacts();

        // do while loop to make menu loop until quit is selected
        do
        {
            System.out.println();
            // IntelliJ showed me this cool print format for the first time. Will use again.
            System.out.println("""
                    1 - Add \s
                    2 - Delete\s
                    3 - View Contacts\s
                    4 - Name Search\s
                    5 - Address Search\s
                    6 - Phone Number Search\s
                    7 - Edit Name\s  
                    8 - Edit Address\s
                    9 - Edit Phone Number\s
                    0 - Quit""");

            System.out.println();
            System.out.format("Enter a command: ");
            try  // try catch for EXTRA CREDIT
            {
                choice = Integer.parseInt(keyboard.nextLine());
                // switch case to use menu for EXTRA CREDIT
                switch (choice)
                {
                    case 1 ->
                    {
                        System.out.println("Add a new contact to the phonebook.\n");
                        System.out.print("Enter first and last Name: ");
                        String name = keyboard.nextLine();
                        System.out.print("Enter address: ");
                        String address = keyboard.nextLine();
                        System.out.print("Enter city: ");
                        String city = keyboard.nextLine();
                        System.out.print("Enter phone number: ");
                        String phoneNumber = keyboard.nextLine();
                        newList.add(name, address, city, phoneNumber);
                    }
                    case 2 ->
                    {
                        System.out.print("Choose a contact to delete (contact number): ");
                        int delete = Integer.parseInt(keyboard.nextLine());
                        System.out.println();
                        newList.delete(delete);
                    }
                    case 3 ->
                    {
                        System.out.println("View Contacts\n");
                        System.out.println();
                        newList.printList();
                    }
                    case 4 ->
                    {
                        System.out.print("Enter a Name to search for: ");
                        String sName = keyboard.nextLine();
                        System.out.println();
                        newList.nameSearch(sName);
                    }
                    case 5 ->
                    {
                        System.out.print("Enter an Address to search for (#### street name): ");
                        String sAddress = keyboard.nextLine();
                        System.out.println();
                        newList.addressSearch(sAddress);
                    }
                    case 6 ->
                    {
                        System.out.print("Enter a phone number to search for (###-###-####): ");
                        String sPhone = keyboard.nextLine();
                        System.out.println();
                        newList.phoneSearch(sPhone);
                    }
                    case 7 ->
                    {
                        System.out.print("Enter the name of the contact you would like to edit (First Last): ");
                        String oldName = keyboard.nextLine();
                        System.out.println("Enter contact's new name (First Last): ");
                        String newName = keyboard.nextLine();
                        System.out.println();
                        newList.editName(oldName, newName);
                    }
                    case 8 ->
                    {
                        System.out.print("Enter the contact's name who you would like to edit (First Last): ");
                        String name = keyboard.nextLine();
                        System.out.println("Enter the contact's new address (xxxx Street Name): ");
                        String newAddress = keyboard.nextLine();
                        System.out.println("Enter the contact's new city (City): ");
                        String newCity = keyboard.nextLine();
                        System.out.println();
                        newList.editAddress(name, newAddress, newCity);
                    }
                    case 9 ->
                    {
                        System.out.print("Enter the old phone number of the contact you wish to edit: (xxx-xxx-xxx): ");
                        String oldPhone = keyboard.nextLine();
                        System.out.println("Enter contact's new phone number (xxx-xxx-xxxx): ");
                        String newPhone = keyboard.nextLine();
                        System.out.println();
                        newList.editPhone(oldPhone, newPhone);
                    }
                    case 0 ->
                    {
                        System.out.println("Quitting Phonebook!");
                        done = true;
                    }
                    default -> System.out.println("Please enter a valid command!");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a ");
            }

        }
        while (!done);
        System.out.println("Goodbye!");
    }

    // using these test contacts were good for testing alphabetical
    // order but I couldn't get them to work with the edit options,
    // kept saying no match found. Didn't have time to get this to work.
//    public static void testContacts()
//    {
//        LList.add("Jerome Garcia", "4462 Shakedown St", "Bellingham", "360-333-9211");
//        LList.add("Henry Wesson", "3130 Pinewood Ave", "Bellingham", "360-739-8635");
//    }


} // end of PhoneBook class
