package exercises.AddressBook.dao;
/* Created by limxuanhui on 26/6/22 */

public class AddressBookDaoException extends Exception {
    public AddressBookDaoException(String message) {
        super(message);
    }

    public AddressBookDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
