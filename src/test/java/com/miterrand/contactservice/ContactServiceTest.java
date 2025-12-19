package com.miterrand.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	private ContactService service;
	private Contact testContact;
	private Contact testContact2;
	private Contact testContact3;
	
	//------------TEST SETUP-----------------
	//This method run before each test initializing starting points for for the testContacts 
	//makes sure tests don't interfere with each other
	@BeforeEach
	void testSetup() 
	{
		service = new ContactService();
		testContact = new Contact("123", "John", "Smith", "0123456789", "456 House St");
		testContact2 = new Contact("456", "Michael", "Scott", "1111122222", "123 Office Dr");
		testContact3 = new Contact("789", "Dwight", "Schrute", "8337583375", "456 Beets Ln");
	}

    //-----------ADD CONTACT TESTS-----------

	//addContact shall add the testContact then test it has been added by updating the first name
    @Test
    void testAddContactSuccess() 
    {
        service.addContact(testContact);
        service.updateFirstName("123", "Johnny");
        assertEquals("Johnny", testContact.getFirstName());
    }
    //addContact shall add multiple contacts then verify they exists by updating the first names
    @Test
    void testAddMultipleContacts() {
        // Add multiple contacts
        service.addContact(testContact);
        service.addContact(testContact2);
        service.addContact(testContact3);

        // Indirectly verify by updating their first names and checking the change
        service.updateFirstName("123", "JohnNew");
        service.updateFirstName("456", "MichaelNew");
        service.updateFirstName("789", "DwightNew");

        assertEquals("JohnNew", testContact.getFirstName());
        assertEquals("MichaelNew", testContact2.getFirstName());
        assertEquals("DwightNew", testContact3.getFirstName());
    }
    //addContact shall throw an exception if contact is null 
    @Test
    void testAddContactIsNull() 
    {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> 
		{
		    service.addContact(null);
		});
        assertEquals("Invalid: Contact must not be null", exception.getMessage());
    }
    //addConctact shall throw an exception if contactID already exists in contactsMap
    //adds testContact then created duplicate with the same contactID to try to add it
    @Test
    void testAddContactDuplicate() 
    {
        service.addContact(testContact);
        Contact duplicateContact = new Contact("123", "Mark", "Wick", "1112223333", "789 Testing St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
        	service.addContact(duplicateContact);
        });
        assertEquals("Invalid: Contact ID already exists", exception.getMessage());
    }
    
    //-----------DELETE CONTACT TESTS-----------
    
    //deleteContact shall delete a contact
    //Test will add testContact then delete the contact identified by 123 which is testContact
    //once deleted the test will attempt to update the first name of testContact
    //Exception shall be thrown when testContact ID is not found 
    @Test
    void testDeleteContactSuccess() 
    {
        service.addContact(testContact);
        service.deleteContact("123");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateFirstName("123", "Johnny");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //deleteContact shall throw an exception when a contactID that does not exist
    //is called to be deleted in this case ID 999 does not exist
    @Test
    void testDeleteNonExistentContact() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.deleteContact("999");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //deleteContact shall throw an exception when a null contactID is attempted to be deleted
    @Test
    void testDeleteContactIsNull() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.deleteContact(null);
        });
        assertEquals("Invalid: Contact ID cannot be null", exception.getMessage());
    }
    
    //-----------UPDATE FIRST NAME TESTS-----------
    
    //updateFirstName shall update the FIRST name of a contactID
    //test will add testContact then update the name 
    //checking it by getting the updated FIRST name and comparing it 
    @Test
    void testUpdateFirstNameSuccess() 
    {
        service.addContact(testContact);
        service.updateFirstName("123", "Johnny");
        assertEquals("Johnny", testContact.getFirstName());
    }
    //updateFirstName will throw and exception if the contact id does not exist
    @Test
    void testUpdateFirstNameNonExistent() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateFirstName("999", "Jim");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //updateFirstName will throw and exception if the contact ID is null
    @Test
    void testUpdateFirstNameNullID() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateFirstName(null, "Jim");
        });
        assertEquals("Invalid: Contact ID cannot be null", exception.getMessage());
    }
    
    //-----------UPDATE LAST NAME TESTS-----------
    
    //updateLastName shall update the LAST name of a contactID
    //test will add testContact then update the name 
    //checking it by getting the updated LAST name and comparing it 
    @Test
    void testUpdateLastNameSuccess() 
    {
        service.addContact(testContact);
        service.updateLastName("123", "Doe");
        assertEquals("Doe", testContact.getLastName());
    }
    //updateLastName will throw and exception if the contact id does not exist
    @Test
    void testUpdateLastNameNonExistent() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateLastName("999", "Doe");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //updateLastName will throw and exception if the contact ID is null
    @Test
    void testUpdateLastNameNullID() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateLastName(null, "Doe");
        });
        assertEquals("Invalid: Contact ID cannot be null", exception.getMessage());
    }
    
    //-----------UPDATE PHONE TESTS-----------
    
    //updatePhone shall update the Phone number
    //the test will add testContact and then update the phone
    //checking it by getting the updated PHONE and comparing it 
    @Test
    void testUpdatePhoneSuccess() 
    {
        service.addContact(testContact);
        service.updatePhone("123", "0987654321");
        assertEquals("0987654321", testContact.getPhone());
    }
    //updatePhone will throw and exception if the contact id does not exist
    @Test
    void testUpdatePhoneNonExistent() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updatePhone("999", "0987654321");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //updatePhone will throw and exception if the contact ID is null
    @Test
    void testUpdatePhoneNullID() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updatePhone(null, "0987654321");
        });
        assertEquals("Invalid: Contact ID cannot be null", exception.getMessage());
    }

    //-----------UPDATE ADDRESS TESTS-----------
    
    //updateAddress shall update the ADDRESS
    //the test will add testContact and then update the address
    //checking it by getting the updated ADDRESS and comparing it 
    @Test
    void testUpdateAddressSuccess() 
    {
        service.addContact(testContact);
        service.updateAddress("123", "147 NewHouse Ln");
        assertEquals("147 NewHouse Ln", testContact.getAddress());
    }
    //updateAddress will throw and exception if the contact id does not exist
    @Test
    void testUpdateAddressNonExistent() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateAddress("999", "147 NewHouse Ln");
        });
        assertEquals("Invalid: Contact ID not found", exception.getMessage());
    }
    //updateAddress will throw and exception if the contact ID is null
    @Test
    void testUpdateAddressNullID() 
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            service.updateAddress(null, "147 NewHouse Ln");
        });
        assertEquals("Invalid: Contact ID cannot be null", exception.getMessage());
    }

}
