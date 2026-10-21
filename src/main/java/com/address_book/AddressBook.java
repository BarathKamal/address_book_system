package com.address_book;

// AddressBook class
public class AddressBook {
    private Contact contact;

    // UC2: Ability to add a new Contact to Address Book
    // method to add contact
    public void addContact(Contact contact) {
        this.contact = contact;
    }


    // UC3: Ability to edit existing contact person using their name
    // Checks whether the contact exists.
    public boolean hasContact(String firstName, String lastName) {
        return contact != null && contact.matchesName(firstName, lastName);
    }

    // Finds the matching contact and updates its details.
    public void editContact(String firstName, String lastName,
                               String address, String city,
                               String state, String zip,
                               String phoneNumber, String email) {
        contact.updateContact(address, city, state, zip,
                phoneNumber, email);

    }


    // UC4: Ability to delete a person using person's name
    // Removes the contact from the address book.
    public void deleteContact() {
        contact = null;
    }

    // Displays the contact information
    public void displayContact() {
        if (contact != null) {
            contact.displayContact();
        } else {
            System.out.println("No contact available.");
        }
    }
}
