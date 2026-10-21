package com.address_book;

/*
UC1: Ability to create Contact in Address
Book with first and last names, address,
city, state, zip, phone number and
email
 */

// Contact class
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    // Contact constructor
    public Contact(String firstName, String lastName,
                   String address, String city, String state,
                   String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Returns the contact's full name.
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // UC3: Ability to edit existing contact person using their name
    // Checks whether both names match the contact.
    public boolean matchesName(String firstName, String lastName) {
        return this.firstName.equalsIgnoreCase(firstName)
                && this.lastName.equalsIgnoreCase(lastName);
    }

    // Updates all editable contact details.
    public void updateContact(String address, String city,
                              String state, String zip,
                              String phoneNumber, String email) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Displays the contact information
    public void displayContact() {
        System.out.println("\n--- Contact Details ---");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("ZIP: " + zip);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}

