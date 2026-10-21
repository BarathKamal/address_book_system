package com.address_book;

// AddressBook class
public class AddressBook {
    private Contact contact;

    // UC2: Ability to add a new Contact to Address Book
    // method to add contact
    public void addContact(Contact contact) {
        this.contact = contact;
    }

    // method to display the contact information
    public void displayContact() {
        if (contact != null) {
            contact.displayContact();
        } else {
            System.out.println("No contact available.");
        }
    }
}
