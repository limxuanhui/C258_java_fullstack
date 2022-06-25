package exercises.AddressBook.controller;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dao.AddressBookDao;
import exercises.AddressBook.dao.AddressBookDaoException;
import exercises.AddressBook.dto.Address;
import exercises.AddressBook.view.AddressBookView;

import java.util.List;
import java.util.Map;

public class AddressBookController {
//    Orchestrate all activities of the program.
//    Use the View and UserIOClass from a previous lab to handle all console input and output
//    Use the AddressBookDao class to store Address objects

    private final AddressBookDao dao;
    private final AddressBookView view;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        int choice;
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                choice = getUserMenuSelection();
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
                        editAddress();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitCommand();
        } catch (AddressBookDaoException e) {
            view.displayResultBanner(e.getMessage());
        }

    }

    private int getUserMenuSelection() {
        return view.getMenuSelection();
    }

    private void addAddress() throws AddressBookDaoException {
        view.displayBanner("Add Address");
        Address addressAdded = dao.addAddress(view.getAddress());
        view.displayResultBanner(addressAdded, "added");
    }

    private void deleteAddress() throws AddressBookDaoException {
        view.displayBanner("Delete Address");
        String lastName = view.getInput("Please enter last name of address to delete: ");
        List<Address> addressesFound = dao.getAddressByLastName(lastName);
        if (!addressesFound.isEmpty()) {
            int choice = view.getDeleteChoice(addressesFound) - 1;
            Address addressToDelete = addressesFound.get(choice);
            Address addressRemoved = dao.removeAddress(addressToDelete);
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

    private void editAddress() throws AddressBookDaoException {
        view.displayBanner("Edit Address");
        String lastName = view.getInput("Please enter last name of address to edit: ");
        List<Address> addressesFound = dao.getAddressByLastName(lastName);
        if (!addressesFound.isEmpty()) {
            int choice = view.getDeleteChoice(addressesFound) - 1;
            Address addressToEdit = addressesFound.get(choice);
            Map<String, String> fieldsToEdit = view.getEditAddressInfo();
            Address editedAddress = dao.editAddress(addressToEdit, fieldsToEdit);
            if (editedAddress != null) {
                view.displayResultBanner(editedAddress, "edited");
            }
        } else {
            view.displayResultBanner("No addresses found for the given last name");
        }
    }

    private void unknownCommand() {
        view.respondToUnknownCommand();
    }

    public void exitCommand() {
        view.respondToExitCommand();
    }

}
