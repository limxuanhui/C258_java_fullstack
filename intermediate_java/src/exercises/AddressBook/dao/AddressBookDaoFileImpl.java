package exercises.AddressBook.dao;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dto.Address;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookDaoFileImpl implements AddressBookDao {
    private final String DELIMITER = ",";
    private final String ADDRESS_BOOK = "src/exercises/AddressBook/address_book.txt";
    private final List<Address> addressBook;

    public AddressBookDaoFileImpl() {
        this.addressBook = new ArrayList<>();
        try {
            loadAddressBook();
        } catch (AddressBookDaoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Address addAddress(Address address) throws AddressBookDaoException {
        loadAddressBook();
        addressBook.add(address);
        writeAddressBook();
        return address;
    }

    @Override
    public Address removeAddress(Address address) throws AddressBookDaoException {
        loadAddressBook();
        addressBook.remove(address);
        writeAddressBook();
        return address;
    }

    @Override
    public Address editAddress(Address address, Map<String, String> fieldsToEdit) throws AddressBookDaoException {
        loadAddressBook();
        for (String field : fieldsToEdit.keySet()) {
            String value = fieldsToEdit.get(field);
            switch (field) {
                case "First Name":
                    address.setFirstName(value);
                    break;
                case "Last Name":
                    address.setLastName(value);
                    break;
                case "Street Name":
                    address.setStreetName(value);
                    break;
                case "Town":
                    address.setTown(value);
                    break;
                case "City":
                    address.setCity(value);
                    break;
                case "Zip Code":
                    address.setZipCode(value);
                    break;
                default:
                    break;
            }
        }
        writeAddressBook();
        return address;
    }

    @Override
    public List<Address> getAddressByLastName(String lastName) {
        List<Address> addressesFound = new ArrayList<>();
        for (Address address : addressBook) {
            if (address.getLastName().equals(lastName)) {
                addressesFound.add(address);
            }
        }
        return addressesFound;
    }

    @Override
    public int getAddressCount() {
        return addressBook.size();
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressBook;
    }

    private Address unmarshallAddress(String addressText) {
        String[] addressTokens = addressText.split(DELIMITER);
        if (addressTokens.length == 6) {
            return new Address(addressTokens[0], addressTokens[1], addressTokens[2],
                               addressTokens[3], addressTokens[4], addressTokens[5]);
        }
        return null;
    }

    private void loadAddressBook() throws AddressBookDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_BOOK)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException("Could not load address book into memory", e);
        }

        String currentLine;
        Address currentAddress;
        addressBook.clear();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentAddress = unmarshallAddress(currentLine);
            addressBook.add(currentAddress);
        }

        scanner.close();
    }

    private String marshallAddress(Address address) {
        String addressText = address.getFirstName() + "," +
                             address.getLastName() + "," +
                             address.getStreetName() + "," +
                             address.getTown() + "," +
                             address.getCity() + "," +
                             address.getZipCode();
        return addressText;
    }

    private void writeAddressBook() throws AddressBookDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_BOOK));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not write address book into file", e);
        }

        String addressText;
        for (Address address : addressBook) {
            addressText = marshallAddress(address);
            out.println(addressText);
            out.flush();
        }

        out.close();
    }
}
