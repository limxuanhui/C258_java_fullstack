package classroster;
/* Created by limxuanhui on 21/6/22 */

import classroster.controller.ClassRosterController;
import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterAuditDaoFileImpl;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.service.ClassRosterServiceLayer;
import classroster.service.ClassRosterServiceLayerImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(dao, auditDao);
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterController controller = new ClassRosterController(service, view);
        controller.run();
    }
}
