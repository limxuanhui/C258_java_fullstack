
/* Created by limxuanhui on 27/7/22 */

import controller.DVDLibraryController;
import dao.DVDLibraryDaoFileImpl;
import view.DVDLibraryView;
import view.io.UserIO;
import view.io.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDaoFileImpl dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);
        controller.run();
    }
}
