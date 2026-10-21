
package com.address_book;

import java.util.HashMap;
import java.util.Map;

// Manages multiple named address books.
public class AddressBookDirectory {
    private final Map<String, AddressBook> addressBooks = new HashMap<>();

    // UC6: Create an address book with a unique name.
    public boolean addAddressBook(String name) {
        if (name == null || name.trim().isEmpty()
                || addressBooks.containsKey(name.trim())) {
            return false;
        }

        addressBooks.put(name.trim(), new AddressBook());
        return true;
    }

    // Retrieves an address book by name.
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // Checks whether an address book exists.
    public boolean containsAddressBook(String name) {
        return addressBooks.containsKey(name);
    }

    // Displays all address book names alphabetically.
    public void displayAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books available.");
            return;
        }

        System.out.println("\n--- Address Books ---");
        addressBooks.keySet().stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }

    // Checks whether the directory is empty.
    public boolean isEmpty() {
        return addressBooks.isEmpty();
    }
}

