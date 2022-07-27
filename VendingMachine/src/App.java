/* Created by limxuanhui on 26/6/22 */

import controller.VendingMachineController;
import io.UserIO;
import io.UserIOConsoleImpl;
import model.dao.VendingMachineDao;
import model.dao.VendingMachineDaoFileImpl;
import model.dto.VendingMachine;
import view.VendingMachineView;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineDao dao = new VendingMachineDaoFileImpl(vendingMachine);
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineController controller = new VendingMachineController(dao, view);
        controller.run();
    }
}
