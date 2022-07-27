package view;
/* Created by limxuanhui on 26/6/22 */

import io.UserIO;
import model.dto.Change;
import model.dto.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineView {
    private final UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void showVendingMachineInterface(VendingMachine vendingMachine) {
        io.print(vendingMachine.toString());
    }

    public Map<Change, Integer> receiveCoins() {
        Map<Change, Integer> coinsInserted = new HashMap<Change, Integer>(){{
            put(Change.QUARTER, 0);
            put(Change.DIME, 0);
            put(Change.NICKEL, 0);
            put(Change.PENNY, 0);
        }};
        int numOfQuarters = io.readInt("How many QUARTERS?", 0);
        int numOfDimes = io.readInt("How many DIMES?", 0);
        int numOfNickels = io.readInt("How many NICKELS?", 0);
        int numOfPennies = io.readInt("How many PENNIES?", 0);
        coinsInserted.put(Change.QUARTER, numOfQuarters);
        coinsInserted.put(Change.DIME, numOfDimes);
        coinsInserted.put(Change.NICKEL, numOfNickels);
        coinsInserted.put(Change.PENNY, numOfPennies);
        return coinsInserted;
    }

    public int promptUserAction() {
        return io.readInt("1. Choose an item | 2. Insert coins | 3. Dispense coins | 4. Quit: ", 1, 4);
    }

    public int promptUserItemSelection(int numberOfOptions) {
        return io.readInt("Choose item: ", 1, numberOfOptions);
    }

    public void displayBanner(String title) {
        io.print("========== " + title + " ==========");
    }
}
