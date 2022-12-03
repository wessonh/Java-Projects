// Lab 6 Binary Search Tree Dictionary
// Nov/23/2022

// This class contains the employee info for individual node in the binary search tree. This class contains
// the mutators and accessors for employee info.

public class EmployeeInfo
{   
    // declaring variables for employee entry in dictionary
    private int employeeNum; // to use for finding employees in the program 
    private String first;
    private String last;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNum; 
    private String email;

// employeeInfo constructors
    public EmployeeInfo(int employeeNum, String first, String last, String address, String city,
    String state, int zip, String phoneNum, String email)
    {
        // initializing variables
        this.employeeNum = employeeNum;
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNum = phoneNum;
        this.email = email;   
    }

    public EmployeeInfo()
    {
        this(0, null, null, null, null, null, 0, null, null);
    }

// mutators VVV 

// method to set the employer number
    public void setEmployeeNum(int employeeNum)
    {
        this.employeeNum = employeeNum;
    }
    
// method to set the first name
    public void setFirst(String first)
    {
        this.first = first;    
    }

// method to set the last name
    public void setLast(String last)
    {
        this.last = last;
    }

// method to set address
    public void setAddress(String address)
    {
        this.address = address;
    }

// method to set city
    public void setCity(String city)
    {
        this.city = city;
    }

// method to set state
    public void setState(String state)
    {
        this.state = state;
    }
    
// method to set zip
    public void setZip(int zip)
    {
        this.zip = zip;
    }

// method to set phone number
    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

// method to set email
    public void setEmail(String email)
    {
        this.email = email;
    }


// accessors VVV

// method to get employeeNum
    public int getEmployeeNum()
    {
        return employeeNum;
    }
    
// method to get the first name
    public String getFirst()
    {
        return first;    
    }

// method to get the last name
    public String getLast()
    {
        return last;
    }

// method to get address
    public String getAddress()
    {
        return address;
    }

// method to get city
    public String getCity()
    {
        return city;
    }

// method to get state
    public String getState()
    {
        return state;
    }
    
// method to get zip
    public int getZip()
    {
        return zip;
    }

// method to get phone number
    public String getPhoneNum() 
    {
        return phoneNum;
    }

// method to get email
    public String getEmail()
    {
        return email;
    }
}
    
