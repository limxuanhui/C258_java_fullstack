package exercises.AddressBook.view;
/* Created by limxuanhui on 25/6/22 */

import exercises.AddressBook.dto.Address;
import io.UserIO;
import io.UserIOConsoleImpl;

import java.util.List;

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
        io.print("6. Quit");
        return io.readInt("Please select the operation you wish to perform: ",1, 6);
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
        String street = io.readString("Please Enter Street Name: ");
        String town = io.readString("Please Enter Town: ");
        String city = io.readString("Please Enter City: ");
        String zipCode = io.readString("Please Enter Zip Code: ");
        return new Address(firstName, lastName, street, town, city, zipCode);
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

    public void respondToUnknownCommand() {
        displayResultBanner("Unknown command.");
    }

    public void respondToExitCommand() {
        displayBanner("Bye!");
    }
}
