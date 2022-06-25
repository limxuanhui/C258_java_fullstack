package exercises.AddressBook.dao;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dto.Address;

import java.util.ArrayList;
import java.util.List;

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
    public Address removeAddress(int index) {
        return addressBook.remove(index);
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
