package com.address_book;

import java.util.Scanner;

// Main class
public class AddressBookMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookDirectory directory = new AddressBookDirectory();        int choice;

        System.out.println("Welcome to Address Book System!");

        // UC6: Manage multiple uniquely named address books
        // Displays the main menu until the user exits.
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. View Address Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readChoice(scanner);

            switch (choice) {
                case 1:
                    createAddressBook(scanner, directory);
                    break;
                case 2:
                    selectAddressBook(scanner, directory);
                    break;
                case 3:
                    directory.displayAddressBooks();
                    break;
                case 0:
                    System.out.println("Exiting Address Book System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Reads a valid integer menu choice.
    private static int readChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // UC6: Create an address book with a unique name.
    private static void createAddressBook(
            Scanner scanner, AddressBookDirectory directory) {

        System.out.print("Enter address book name: ");
        String name = scanner.nextLine().trim();

        if (directory.addAddressBook(name)) {
            System.out.println("Address book created successfully!");
        } else {
            System.out.println("Invalid or duplicate address book name.");
        }
    }

    // UC6: Select an address book by name.
    private static void selectAddressBook(
            Scanner scanner, AddressBookDirectory directory) {

        if (directory.isEmpty()) {
            System.out.println("Create an address book first.");
            return;
        }

        directory.displayAddressBooks();

        System.out.print("Enter address book name: ");
        String name = scanner.nextLine().trim();

        AddressBook addressBook = directory.getAddressBook(name);

        if (addressBook == null) {
            System.out.println("Address book not found.");
            return;
        }

        manageContacts(scanner, addressBook, name);
    }

    // UC5: Manage multiple contacts within the selected address book.
    // Routes contact operations through a menu.
    private static void manageContacts(
            Scanner scanner, AddressBook addressBook, String name) {

        int choice;

        do {
            System.out.println("\n--- Address Book: " + name + " ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = readChoice(scanner);

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
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // UC2: Add a new contact to the selected address book.
    private static void addContact(
            Scanner scanner, AddressBook addressBook) {

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
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, address,
                city, state, zip, phone, email);

        addressBook.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    // UC3: Edit an existing contact by name.
    // Requests updated details only when the contact exists.
    private static void editContact(
            Scanner scanner, AddressBook addressBook) {

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
        String phone = scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        addressBook.editContact(firstName, lastName, address, city,
                state, zip, phone, email);

        System.out.println("Contact updated successfully!");
    }

    // UC4: Delete a contact by name.
    private static void deleteContact(
            Scanner scanner, AddressBook addressBook) {

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        if (addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}


