package com.miterrand.contactservice;

public class Contact {
	
    private final String contactID;		//final used here to make contactID immutable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

	//Parameterized constructor initializing Contact object with private arguments 
    public Contact(String contactID, String firstName, String lastName, String phone, String address) 
    {

        //----------Contact ID---contactID must not be updatable(immutable) so only needs to be in the constructor-------
        if (contactID == null || contactID.length() > 10) 
        {
            throw new IllegalArgumentException("Invalid: contact ID must not be null and not surpass 10 characters");
        }
        this.contactID = contactID;

        //----------First Name----------
        if (firstName == null || firstName.length() > 10) 
        {
            throw new IllegalArgumentException("Invalid: first name must not be null and not surpass 10 characters");
        }
        this.firstName = firstName;

        //----------Last Name----------
        if (lastName == null || lastName.length() > 10) 
        {
            throw new IllegalArgumentException("Invalid: last name must not be null and not surpass 10 characters");
        }
        this.lastName = lastName;

        //----------phone number----------
        if (phone == null || phone.length() != 10) 
        {
            throw new IllegalArgumentException("Invalid: phone number must not be null and must be 10 characters long");
        }
        this.phone = phone;

        //----------Address----------
        if (address == null || address.length() > 30) 
        {
            throw new IllegalArgumentException("Invalid: address must not be null and not surpass 30 characters");
        }
        this.address = address;
    }

	    //****Getters*****
	    public String getContactID() 
	    { 
	    	return contactID; 
	    }
	    public String getFirstName() 
	    { 
	    	return firstName; 
	    }
	    public String getLastName() 
	    { 
	    	return lastName; 
	    }
	    public String getPhone() 
	    { 
	    	return phone; 
	    }
	    public String getAddress() 
	    {
	    	return address; 
	    }

	    //*****Setters***updating objects fields need to also be validated*****
	    public void setFirstName(String firstName) 
	    {
	        if (firstName == null || firstName.length() > 10) 
	        {
	            throw new IllegalArgumentException("Invalid: first name must not be null and not surpass 10 characters");
	        }
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) 
	    {
	        if (lastName == null || lastName.length() > 10) 
	        {
	            throw new IllegalArgumentException("Invalid: last name must not be null and not surpass 10 characters");
	        }
	        this.lastName = lastName;
	    }

	    public void setPhone(String phone) 
	    {
	        if (phone == null || phone.length() != 10) 
	        {
	            throw new IllegalArgumentException("Invalid: phone number must not be null and must be 10 characters long");
	        }
	        this.phone = phone;
	    }

	    public void setAddress(String address) 
	    {
	        if (address == null || address.length() > 30) 
	        {
	            throw new IllegalArgumentException("Invalid: address must not be null and not surpass 30 characters");
	        }
	        this.address = address;
	    }
	}

