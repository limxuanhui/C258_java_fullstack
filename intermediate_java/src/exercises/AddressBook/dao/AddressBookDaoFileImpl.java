package exercises.AddressBook.dao;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dto.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressBookDaoFileImpl implements AddressBookDao {
    private List<Address> addressBook;

    public AddressBookDaoFileImpl() {
        this.addressBook = new ArrayList<>();
    }

    @Override
    public Address addAddress(Address address) {
        addressBook.add(address);
        return address;
    }

    @Override
    public Address removeAddress(Address address) {
        addressBook.remove(address);
        return address;
    }

    @Override
    public Address editAddress(Address address, Map<String, String> fieldsToEdit) {
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
}
