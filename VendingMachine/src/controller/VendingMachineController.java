package controller;
/* Created by limxuanhui on 26/6/22 */

import model.dao.VendingMachineDao;
import model.dao.VendingMachineDaoException;
import model.dto.Change;
import model.dto.VendingMachine;
import view.VendingMachineView;

import java.util.Map;

public class VendingMachineController {
    private VendingMachineDao dao;
    private VendingMachineView view;

    public VendingMachineController(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                showVendingMachineInterface(dao.getVendingMachine());
                int userSelection = getUserAction();
                switch (userSelection) {
                    case 1:
                        handleItemSelection();
                        break;
                    case 2:
                        handleCoinsInsertion();
                        break;
                    case 3:
                        handleCoinsDispense();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        handleUnknownCommand();
                }
            }
            handleQuit();
        } catch (VendingMachineDaoException e) {
            System.out.println(e.getMessage());
        }

    }

    private void showVendingMachineInterface(VendingMachine vendingMachine) {
        view.showVendingMachineInterface(vendingMachine);
    }

    private int getUserAction() {
        return view.promptUserAction();
    }

    private void handleItemSelection() {
        view.displayBanner("Selecting item");
    }

    private void handleCoinsInsertion() {
        view.displayBanner("Inserting coins");
        Map<Change, Integer> coinsInserted = view.
    }

    private void handleCoinsDispense() {
        view.displayBanner("Dispensing coins");
    }

    private void handleUnknownCommand() {
        view.displayBanner("Unknown command");
    }

    private void handleQuit() {
        view.displayBanner("Bye");
    }
}
