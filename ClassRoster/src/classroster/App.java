package classroster;
/* Created by limxuanhui on 21/6/22 */

import classroster.controller.ClassRosterController;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterController controller = new ClassRosterController(dao, view);
        controller.run();
    }
}
