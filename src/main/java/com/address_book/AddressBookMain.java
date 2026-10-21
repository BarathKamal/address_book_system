package com.address_book;

import java.util.Scanner;

// Main class
public class AddressBookMain {

    // UC2: Ability to add a new Contact to Address Book
    // Collects details and adds a new contact.
    public static void addContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("\n--- Add Contact ---");

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

        Contact contact = new Contact(firstName, lastName, address,
                city, state, zip, phoneNumber, email);

        addressBook.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    // UC3: Ability to edit existing contact person using their name
    // Collects new details only if the contact exists.
    public static void editContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("\n--- Edit Contact ---");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        if (addressBook.findContact(firstName, lastName) == null) {
            System.out.println("Contact not found.");
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
    }

    // UC4: Ability to delete a person using person's name
    // Deletes the contact matching the entered name.
    public static void deleteContact(Scanner scanner, AddressBook addressBook) {
        System.out.println("\n--- Delete Contact ---");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        if (addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found. No deletion performed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;

        System.out.println("Welcome to Address Book System!");

        // UC5: Ability to add multiple persons to Address Book
        // Repeats the menu until the user chooses to exit.
        do {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.nextLine();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(scanner, addressBook);
                    break;
                case 2:
                    editContact(scanner, addressBook);
                    break;
                case 3:
                    deleteContact(scanner, addressBook);
                    break;
                case 4:
                    addressBook.displayContacts();
                    break;
                case 0:
                    System.out.println("Exiting Address Book System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

