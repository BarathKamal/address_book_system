
package com.address_book;

import java.util.ArrayList;
import java.util.List;

// Manages multiple contacts in the address book.
public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    // UC2: Ability to add a new Contact to Address Book
    // Adds a contact to the collection.
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Finds a contact using first and last name.
    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.matchesName(firstName, lastName)) {
                return contact;
            }
        }
        return null;
    }

    // UC3: Ability to edit existing contact person using their name
    // Updates the details of the matching contact.
    public boolean editContact(String firstName, String lastName,
                               String address, String city, String state,
                               String zip, String phoneNumber, String email) {
        Contact contact = findContact(firstName, lastName);

        if (contact == null) {
            return false;
        }

        contact.updateContact(address, city, state, zip, phoneNumber, email);
        return true;
    }

    // UC4: Ability to delete a person using person's name
    // Removes the matching contact from the collection.
    public boolean deleteContact(String firstName, String lastName) {
        Contact contact = findContact(firstName, lastName);

        if (contact == null) {
            return false;
        }

        contacts.remove(contact);
        return true;
    }

    // UC5: Ability to add multiple persons to Address Book
    // Displays every contact stored in the collection.
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }

        for (Contact contact : contacts) {
            contact.displayContact();
        }
    }
}

