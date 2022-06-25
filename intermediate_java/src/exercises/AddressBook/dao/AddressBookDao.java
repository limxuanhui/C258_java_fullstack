package exercises.AddressBook.dao;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.dto.Address;

import java.util.List;
import java.util.Map;

public interface AddressBookDao {
//    Add an Address
//    Remove an Address
//    Find an Address by last name
//    Return a count of Addresses in the AddressBookDao
//    Return all of the Addresses in the AddressBookDao

    Address addAddress(Address address);
    Address removeAddress(Address address);
    Address editAddress(Address address, Map<String, String> fieldsToEdit);
    List<Address> getAddressByLastName(String lastName);
    int getAddressCount();
    List<Address> getAllAddresses();
}
