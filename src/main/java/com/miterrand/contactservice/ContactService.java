package com.miterrand.contactservice;

import java.util.HashMap;
import java.util.Map;


public class ContactService {
	
	private Map<String,Contact> contactsMap;
	
	//Constructor 
	public ContactService() 
	{
		contactsMap = new HashMap<>();
	}
	
	//helper method to check contactID for fields which need updating 
	//if contactID inputed does not exists throw an exception
	private Contact getValidatedContact(String contactID)
	{
    	//checks if contactI to be checked is null, throws exception if null
        if (contactID == null) 
        {
            throw new IllegalArgumentException("Invalid: Contact ID cannot be null");
        }
        Contact contact = contactsMap.get(contactID);
        if (contact == null) 
        {
            throw new IllegalArgumentException("Invalid: Contact ID not found");
        }
        return contact;
	}
	
	//Following methods add or delete a contact they both check if the contact 
	//to be added or deleted is not null and if it is existing 
    //---------addContact---------
    public void addContact(Contact contact) 
    {
    	//checking if contact is null
        if (contact == null) 
        {
            throw new IllegalArgumentException("Invalid: Contact must not be null");
        }
        //id is set to contact if not null
        String id = contact.getContactID();
        //checking if contact already exists in contact map
        if (contactsMap.containsKey(id)) 
        {
            throw new IllegalArgumentException("Invalid: Contact ID already exists");
        }
        //contact is added if contact is not null and not existing
        contactsMap.put(id, contact);
    }

    //---------deleteContact---------
    public void deleteContact(String contactID) 
    {
    	//checks deleted contactID is not null
    	if (contactID == null)
    	{
    		throw new IllegalArgumentException("Invalid: Contact ID cannot be null");
    	}
    	//checking if contact to be deleted actually exists
        if (!contactsMap.containsKey(contactID)) 
        {
            throw new IllegalArgumentException("Invalid: Contact ID not found");
        }
        //if contact is not null and exists then proceed to delete it
        contactsMap.remove(contactID);
    }

    
    //Following methods UPDATE first name, last name, phone, and address
    //Based on contactIDs which need to be existing in the contactsMap 
    //Utilizing helper method getValidatedContact() 
    //to validate if contactIDs exist in the map
    
    //---------updateFirstName---------
    public void updateFirstName(String contactID, String newFirstName) 
    {
    	//checks if contactID exists in the map
        Contact contact = getValidatedContact(contactID);
        //if contact exists set the new first name 
        contact.setFirstName(newFirstName);
    }

    //---------updateLastName---------
    public void updateLastName(String contactID, String newLastName) 
    {
    	//checks if contact id exists in the map
    	Contact contact = getValidatedContact(contactID);
        //updates last name if contact exists
        contact.setLastName(newLastName);
    }

    //---------updatePhone---------
    public void updatePhone(String contactID, String newPhone) 
    {
    	//checks if contact id exists in the map 
    	Contact contact = getValidatedContact(contactID);
        //if check passes phone number is updated
        contact.setPhone(newPhone);
    }

    //---------updateAddress---------
    public void updateAddress(String contactID, String newAddress) 
    {
    	//checks if contact exists in the map 
    	Contact contact = getValidatedContact(contactID);
        //if contact exists updates address
        contact.setAddress(newAddress);
    }
}


