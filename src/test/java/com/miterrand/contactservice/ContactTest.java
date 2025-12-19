package com.miterrand.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	private Contact testContact;
	
	//testContact is a valid object to be used throughout the testing.
	@BeforeEach
	void testSetup()
	{
		testContact = new Contact("123", "John", "Smith", "0123456789", "456 House St");
	}
	
    //************** CONSTRUCTOR VALID CONTACT TEST **************
	
	//validating testContact is a valid object all fields are within limits
    @Test
    void testCreateValidContact() 
    {
        assertEquals("123", testContact.getContactID());
        assertEquals("John", testContact.getFirstName());
        assertEquals("Smith", testContact.getLastName());
        assertEquals("0123456789", testContact.getPhone());
        assertEquals("456 House St", testContact.getAddress());
    }
    
 // ************** CONSTRUCTOR INVALID TESTS **************
    //Constructor throws an exception if the contactID is longer than 10 characters
    @Test
    void testContactIdTooLong() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            new Contact("12345678901", "John", "Smith", "0123456789", "456 House St");
        });
        assertEquals("Invalid: contact ID must not be null and not surpass 10 characters", exception.getMessage());
    }

    //Constructor throws an exception if the first name is longer than 10 characters
    @Test
    void testFirstNameTooLong() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            new Contact("123", "Johnnnnnnnnnn", "Smith", "0123456789", "456 House St");
        });
        assertEquals("Invalid: first name must not be null and not surpass 10 characters", exception.getMessage());
    }

    //Constructor throws an exception is the last name is longer than 10 characters 
    @Test
    void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smithhhhhhhhh", "0123456789", "456 House St");
        });
        assertEquals("Invalid: last name must not be null and not surpass 10 characters", exception.getMessage());
    }

    //Constructor throws an exception if the phone is not exactly 10 characters long
    @Test
    void testPhoneInvalidLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "012345", "456 House St"); // 6 digits
        });
        assertEquals("Invalid: phone number must not be null and must be 10 characters long", exception.getMessage());
    }

    //Constructor throws an exception if the address surpasses 30 characters
    @Test
    void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Smith", "0123456789", "12345 Very Long Street Name Exceeding Limit St");
        });
        assertEquals("Invalid: address must not be null and not surpass 30 characters", exception.getMessage());
    }
    
    // ************** SETTER VALIDATION TESTS **************
    
    //--------setFirstName TEST--------
    //setFirstName validation test to verify name is set.
    @Test
    void testSetFirstNameValid() 
    {
        testContact.setFirstName("Pam");
        assertEquals("Pam", testContact.getFirstName());
    }
    
    //setFirstName test checks first name does not surpass 10 characters or throws exception
    @Test
    void testSetFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            testContact.setFirstName("ThisNameIsTooLong");
        });
        assertEquals("Invalid: first name must not be null and not surpass 10 characters", exception.getMessage());
    }
    
    //--------setLastName TEST--------
    //setLastName validation test to verify name is set.
    @Test
    void testSetLastNameValid() 
    {
        testContact.setLastName("Beesly");
        assertEquals("Beesly", testContact.getLastName());
    }
    
    //setLastName test checks if the last name exceeds 10 characters an exception is thrown
    @Test
    void testSetLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            testContact.setLastName("ThisLastNameIsTooLong");
        });
        assertEquals("Invalid: last name must not be null and not surpass 10 characters", exception.getMessage());
    }
    
    //--------setAddress TEST--------
    //setFirstName validation test to verify name is set.
    @Test
    void testSetAddressValid() 
    {
        testContact.setAddress("2467 ValidAd Dr");
        assertEquals("2467 ValidAd Dr", testContact.getAddress());
    }
    
    //setAddress test, checks if the address exceeds 30 characters an exception is thrown
    @Test
    void testSetAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            testContact.setAddress("12345 Very Long Street Name Exceeding Limit St");
        });
        assertEquals("Invalid: address must not be null and not surpass 30 characters", exception.getMessage());
    }

    //--------setPhone TEST--------
    //setFirstName validation test to verify name is set.
    @Test
    void testSetPhoneValid() 
    {
        testContact.setPhone("2468001357");
        assertEquals("2468001357", testContact.getPhone());
    }
    
    //setPhone test checking if a phone with less than 10 characters throws an exception
    @Test
    void testSetPhoneInvalidLength() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            testContact.setPhone("012345"); // 6 digits
        });
        assertEquals("Invalid: phone number must not be null and must be 10 characters long", exception.getMessage());
    }

}
