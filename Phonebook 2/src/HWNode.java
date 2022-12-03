// Henry Wesson
// CS - 145
// Assignment 1 - Phonebook
// October 16, 2022

// This my HWNode for my phonebook linked list. contains getters and setters and to String method.

// start of HWNode class
public class HWNode
{
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private HWNode next;

    // sets PBNode to null;
    public HWNode()
    {
        next = null;
    }

    public String getName() //getName
    {
        return name;
    }

    public void setName(String name) //setName
    {
        this.name = name;
    }

    public String getAddress() // getAddress
    {
        return address;
    }
    public void setAddress(String address) //setAddress
    {
        this.address = address;
    }
    public void setCity(String city) //setAddress
    {
        this.city = city;
    }

    public String getCity() // never ended up using this but probably will when I add to this later.
    {
        return city;
    }

    public String getPhoneNumber() //getPhone
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) //setPhone
    {
        this.phoneNumber = phoneNumber;
    }

    public HWNode getNext() //getNext
    {
        return next;
    }

    public void setNext(HWNode next) //setNext
    {
        this.next = next;
    }

    public String toString() // prints string for phonebook list.
    {
        return "Name = " + name + ", Address = " + address + ", City = " + city + ", Phone Number = "
                + phoneNumber;
    }
} // end of HWNode
