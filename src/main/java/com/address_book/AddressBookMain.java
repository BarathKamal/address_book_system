package com.address_book;

import java.util.Scanner;

// Main class
public class AddressBookMain {

    // UC3: Ability to edit existing contact person using their name
    // Collects new details only when the contact is found.
    public static void editContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("\n--- Edit Contact ---");

        System.out.print("Enter first name to search: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();

        if (!addressBook.hasContact(firstName, lastName)) {
            System.out.println("Contact not found. No changes made.");
            return;
        }

        System.out.print("Enter new address: ");
        String address = scanner.nextLine();

        System.out.print("Enter new city: ");
        String city = scanner.nextLine();

        System.out.print("Enter new state: ");
        String state = scanner.nextLine();

        System.out.print("Enter new ZIP code: ");
        String zip = scanner.nextLine();

        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        addressBook.editContact(firstName, lastName, address, city,
                state, zip, phoneNumber, email);

        System.out.println("Contact updated successfully!");
        addressBook.displayContact();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book System!");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();

        System.out.print("Enter ZIP code: ");
        String zip = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName, lastName, address, city,
                state, zip, phoneNumber, email
        );

        addressBook.addContact(contact);
        addressBook.displayContact();

        editContact(scanner, addressBook);

        scanner.close();
    }
}
