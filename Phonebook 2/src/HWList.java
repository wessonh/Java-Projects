// Henry Wesson
// CS - 145
// Assignment 1 - Phonebook
// October 16, 2022

// This is my linked list class for my phonebook program. I got the edit options to work correctly, but they wouldn't
// work with my testContacts. They work perfectly if you use them on contacts you added yourself. Commented out the
// testContacts in my PhoneBook.java class.

public class HWList // start Linked List class
{
    private static HWNode head;
    private static int length;

    // method to initialize list
    public HWList()
    {
        head = null;
        length = 0;
    }

    // add method to add name, email, and phone number to phonebook as String

    public static void add(String name, String address, String city, String phoneNumber)
    {

        HWNode current = head;
        HWNode previous = null;
        HWNode newNode = new HWNode();

        newNode.setName(name);
        newNode.setAddress(address);
        newNode.setCity(city);
        newNode.setPhoneNumber(phoneNumber);

        // when there is no head, new entry automatically becomes the head and length increases

        if (isEmpty())
        {
            head = newNode;
            length++;
        }
        else
        {
            // sorts the list in alphabetical order
            // by first letter in last name
            for (int i = 0; i < length; i++)
            {
                String[] ourNames1 = current.getName().split(" ");
                String[] ourNames2 = newNode.getName().split(" ");

                int result = ourNames1[ourNames1.length-1].compareToIgnoreCase(ourNames2[ourNames2.length-1]);

                // if last name is first alphabetically to current head
                // this entry becomes the new head
                if (result > 0)
                {
                    if (previous == null)
                    {
                        newNode.setNext(current);
                        head = newNode;
                        length++;
                        break;
                    }
                    // this goes through middle nodes as long as it is not the end (tail)
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    length++;
                    break;
                }
                else // if the new entry is last alphabetically is becomes the new tail.
                {
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        length++;
                        break;
                    }
                    // System.out.println("Add after");
                    previous = current;
                    current = current.getNext();
                }
            }
        }
    }
    // printList method to display contacts
    public void printList ()
    {
        // checks if list is empty or not
        HWNode tempNode = head;
        if (head == null)
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // for loop to go through list and print in the correct order
            for (int i = 0; i < length; i++) {
                System.out.print("Contact Number = " + (i+1) + " ");
                System.out.println(tempNode);
                tempNode = tempNode.getNext();
            }
        }
        System.out.println();
    }
    // method for if the linked list is empty
    public static boolean isEmpty()
    {
        return (length == 0);
    }

    // method used to search by name
    public void nameSearch(String name)
    {
        HWNode current = head;
        boolean empty = true;

        // checks to see if the list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // check to see if input matches what is contained in string
            for (int i = 0; i < length; i++)
            {
                if (current.getName().toLowerCase().contains(name.toLowerCase()))
                {
                    System.out.print("Contact Number = " + (i+1) + " ");
                    System.out.println(current);
                    empty = false;
                }
                // if string doesn't have a match, search the next node
                current = current.getNext();
            }
            // cannot find name
            if (empty){
                System.out.println("Cannot find name!");
            }
        }
    }
    // method to search for address
    public void addressSearch(String address)
    {
        HWNode current = head;
        boolean empty = true;
        // checks to see if list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // checks to see if new entry matches first in linked list
            for (int i = 0; i < length; i++)
            {
                if (current.getAddress().toLowerCase().contains(address.toLowerCase()))
                {
                    System.out.print("Contact number = " + (i+1) + " ");
                    System.out.println(current);
                    empty = false;
                }
                // if nothing is found in node goes to next node
                current = current.getNext();
            }
            // if no matches
            if (empty)
            {
                System.out.println("Cannot find address!");
            }
        }
    }
    public void phoneSearch(String phoneNumber) // phone search method
    {
        HWNode current = head;
        boolean empty = true;
        // checks to see if list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // checks to see if new entry matches first in linked list
            for (int i = 0; i < length; i++)
            {
                if (current.getPhoneNumber().toLowerCase().contains(phoneNumber))
                {
                    System.out.print("Contact number = " + (i+1) + " ");
                    System.out.println(current);
                    empty = false;
                }
                // if nothing matches in current node then moves onto next
                current = current.getNext();
            }
            // no matches found
            if (empty)
            {
                System.out.println("Cannot find phone number!");
            }
        }

    }
    // method to delete contacts by contact number (index)
    // probably could have done this better (like a search by name, etc.) but didn't end up having time.
    public void delete (int contactNum)
    {
        HWNode current = head;
        HWNode previous = null;
        boolean empty = true;
        // checks to see if list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // for and contained if/else finds index and deletes it
            for (int i = 0; i < length; i++)
            {
                if ((contactNum-1) == i)
                {
                    if (previous == null)
                    {
                        head = head.getNext();
                        length--;
                        empty = false;
                        break;
                    }
                    else if (current.getNext() == null)
                    {
                        previous.setNext(null);
                        length--;
                        empty = false;
                        break;
                    }
                    else
                    {
                        previous.setNext(current.getNext());
                        length--;
                        empty = false;
                        break;
                    }
                }
                else
                {
                    previous = current;
                    current = current.getNext();
                }
            }
            if (empty)
            {
                System.out.println("Contact not found! Enter valid contact number");
            }
            else
            {
                // upon successful deletion
                System.out.println("Successfully deleted contact " + contactNum);
            }
        }
    }
    // edit name method. changes name element to new string entry
    public void editName(String oldName, String newName) {
        HWNode current = head;
        boolean empty = true;
        //checks if list is empty
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            // updates contacts name with new entry
            while (current.getNext() != null) {
                if (current.getName().equals(oldName)) {
                    current.setName(newName);
                    System.out.println("\nContact info updated!\n");
                    System.out.println(current);
                    empty = false;
                }
                current = current.getNext(); // says is always null, I couldn't figure this out.
            }
            // no matches found
            if (empty) {
                System.out.println("No matches found!");
            }
        }
    }
    // edit Address method. changes address and city element to new string entry.
    public void editAddress(String name, String newAddress, String newCity)
    {
        HWNode current = head;
        boolean empty = true;
        //checks if list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // edits address and city when finding contact with entered name.
            while(current.getNext() != null)
            {
                if(current.getName().equals(name))
                {
                    current.setAddress(newAddress);
                    current.setCity(newCity);
                    System.out.println("\nContact info updated!\n");
                    System.out.println(current);
                    empty = false;
                }
                current = current.getNext();
            }
            // no matches found
            if (empty)
            {
                System.out.println("No matches found!");
            }
        }
    }
    // method changes phoneNumber element with new String entry.
    public void editPhone(String oldPhone, String newPhone)
    {
        HWNode current = head;
        boolean empty = true;
        //checks if list is empty
        if (isEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            // edits phone number to new String entry.
            while (current.getNext() != null)
            {
                if (current.getPhoneNumber().equals(oldPhone))
                {
                    current.setPhoneNumber(newPhone);
                    System.out.println("\nContact info updated!\n");
                    System.out.println(current);
                    empty = false;
                }
                current = current.getNext();
            }
            // no matches
            if (empty)
            {
                System.out.println("No matches found!");
            }
        }
    }
} // end of LList Class
