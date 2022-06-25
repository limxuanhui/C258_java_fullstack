package exercises.AddressBook.view;
/* Created by limxuanhui on 25/6/22 */

import exercises.AddressBook.dto.Address;
import io.UserIO;
import io.UserIOConsoleImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookView {
    private UserIO io = new UserIOConsoleImpl();

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int getMenuSelection() {
        io.print("========================");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Edit Address");
        io.print("7. Quit");
        return io.readInt("Please select the operation you wish to perform: ",1, 7);
    }

    public void displayBanner() {
        io.print("====================");
    }

    public void displayBanner(String title) {
        io.print("========== " + title + " ==========");
    }

    public void promptContinue() {
        io.readString("Please hit enter to continue _");
    }

    public void displayResultBanner() {
        displayBanner();
        promptContinue();
    }

    public void displayResultBanner(String result) {
        displayBanner(result);
        promptContinue();
    }

    public void displayResultBanner(Address address, String result) {
        displayBanner();
        displayAddress(address);
        io.print("has been " + result + ".");
        displayBanner();
        promptContinue();
    }

    public Address getAddress() {
        String firstName = io.readString("Please Enter First Name: ");
        String lastName = io.readString("Please Enter Last Name: ");
        String streetName = io.readString("Please Enter Street Name: ");
        String town = io.readString("Please Enter Town: ");
        String city = io.readString("Please Enter City: ");
        String zipCode = io.readString("Please Enter Zip Code: ");
        return new Address(firstName, lastName, streetName, town, city, zipCode);
    }

    public String getInput(String prompt) {
        return io.readString(prompt);
    }

    public int getDeleteChoice(List<Address> addresses) {
        int count = 1;
        for (Address address: addresses) {
            io.print(count++ + ".");
            displayAddress(address);
        }
        return io.readInt("Delete which address? ", 1, addresses.size());
    }

    public void displayAddress(Address address) {
        io.print(address.toString());
    }

    public void displayAddresses(List<Address> addresses) {
        for (Address address : addresses) {
            displayAddress(address);
        }
        displayResultBanner("found");
    }

    public void displayAddressCount(int count) {
        displayResultBanner("" + count);
    }

    public Map<String, String> getEditAddressInfo() {
        Map<String, String> fieldsToEdit = new HashMap<>();

        String toEditFirstName = io.readYesNo("Edit First Name? ");
        if (toEditFirstName.equals("y")) {
            String newFirstName = io.readString("New First Name: ");
            fieldsToEdit.put("First Name", newFirstName);
        }

        String toEditLastName = io.readYesNo("Edit Last Name?");
        if (toEditLastName.equals("y")) {
            String newLastName = io.readString("New Last Name: ");
            fieldsToEdit.put("Last Name", newLastName);
        }

        String toEditStreetName = io.readYesNo("Edit Street Name?");
        if (toEditStreetName.equals("y")) {
            String newStreetName = io.readString("New Street Name: ");
            fieldsToEdit.put("Street Name", newStreetName);
        }

        String toEditTown = io.readYesNo("Edit Town?");
        if (toEditTown.equals("y")) {
            String newTown = io.readString("New Town: ");
            fieldsToEdit.put("Town", newTown);
        }

        String toEditCity = io.readYesNo("Edit City?");
        if (toEditCity.equals("y")) {
            String newCity = io.readString("New City: ");
            fieldsToEdit.put("City", newCity);
        }

        String toEditZipCode = io.readYesNo("Edit Zip Code?");
        if (toEditZipCode.equals("y")) {
            String newZipCode = io.readString("New Zip Code: ");
            fieldsToEdit.put("Zip Code", newZipCode);
        }
        return fieldsToEdit;
    }

    public void respondToUnknownCommand() {
        displayResultBanner("Unknown command.");
    }

    public void respondToExitCommand() {
        displayBanner("Bye!");
    }
}
