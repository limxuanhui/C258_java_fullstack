package exercises.AddressBook;
/* Created by limxuanhui on 23/6/22 */

import exercises.AddressBook.controller.AddressBookController;
import exercises.AddressBook.dao.AddressBookDao;
import exercises.AddressBook.dao.AddressBookDaoFileImpl;
import exercises.AddressBook.view.AddressBookView;
import io.UserIO;
import io.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        AddressBookDao dao = new AddressBookDaoFileImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookController controller = new AddressBookController(dao, view);
        controller.run();
    }
}
