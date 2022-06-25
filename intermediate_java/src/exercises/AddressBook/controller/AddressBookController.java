package exercises.AddressBook.controller;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dao.AddressBookDao;
import exercises.AddressBook.dto.Address;
import exercises.AddressBook.view.AddressBookView;

import java.util.List;

public class AddressBookController {
//    Orchestrate all activities of the program.
//    Use the View and UserIOClass from a previous lab to handle all console input and output
//    Use the AddressBookDao class to store Address objects

    private AddressBookDao dao;
    private AddressBookView view;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        System.out.println("Running");
        boolean keepGoing = true;
        while (keepGoing) {
            int choice = getUserMenuSelection();
            switch (choice) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    deleteAddress();
                    break;
                case 3:
                    findAddress();
                    break;
                case 4:
                    listAddressCount();
                    break;
                case 5:
                    listAllAddresses();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitCommand();
    }

    private int getUserMenuSelection() {
        return view.getMenuSelection();
    }

    private void addAddress() {
        view.displayBanner("Add Address");
        Address addressAdded = dao.addAddress(view.getAddress());
        view.displayResultBanner(addressAdded, "added");
    }

    private void deleteAddress() {
        view.displayBanner("Delete Address");
        String lastName = view.getInput("Please enter last name of address to delete: ");
        List<Address> addressesFound = dao.getAddressByLastName(lastName);
        if (!addressesFound.isEmpty()) {
            int choice = view.getDeleteChoice(addressesFound) - 1;
            Address addressRemoved = dao.removeAddress(choice);
            if (addressRemoved != null) {
                view.displayResultBanner(addressRemoved, "deleted");
            }
        } else {
            view.displayResultBanner("No addresses found for the given last name");
        }
    }

    private void findAddress() {
        view.displayBanner("Find Address");
        String lastName = view.getInput("Please enter last name of address to find: ");
        List<Address> addressesFound = dao.getAddressByLastName(lastName);
        if (!addressesFound.isEmpty()) {
            view.displayAddresses(addressesFound);
        } else {
            view.displayResultBanner("No address found under the given last name");
        }

    }

    private void listAddressCount() {
        view.displayBanner("Number of Addresses");
        view.displayAddressCount(dao.getAddressCount());
    }

    private void listAllAddresses() {
        view.displayBanner("All Addresses");
        List<Address> addresses = dao.getAllAddresses();
        if (!addresses.isEmpty()) {
            view.displayAddresses(addresses);
        } else {
            view.displayResultBanner("Address book is empty");
        }
    }

    private void unknownCommand() {
        view.respondToUnknownCommand();
    }

    public void exitCommand() {
        view.respondToExitCommand();
    }

}
