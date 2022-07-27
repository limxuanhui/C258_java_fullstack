package model.dao;
/* Created by limxuanhui on 27/6/22 */

import model.dto.Change;
import model.dto.VendingMachine;
import model.dto.VendingMachineItem;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDao {
    private final String DELIMITER = ",";
    private final String VENDING_MACHINE_INVENTORY = "src/vending-machine-inventory.txt";
    private final String VENDING_MACHINE_CHANGE = "src/vending-machine-change.txt";
    private VendingMachine vendingMachine;

    public VendingMachineDaoFileImpl(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        try {
            loadVendingMachineData();
        } catch (VendingMachineDaoException e) {
            System.out.println("Could not load vending machine data");
        }
    }

    @Override
    public VendingMachine getVendingMachine() throws VendingMachineDaoException {
        loadVendingMachineData();
        return vendingMachine;
    }

    @Override
    public void vendItem(VendingMachineItem item, Map<Change, Integer> payment) {

    }

    @Override
    public Map<Change, Integer> dispenseChange() {
        System.out.println("Dispensing change");
        return null;
    }

    private VendingMachineItem unmarshallVendingMachineItem(String itemString) {
        String[] itemTokens = itemString.split(DELIMITER);
        int index = Integer.parseInt(itemTokens[0]);
        String name = itemTokens[1];
        BigDecimal price = BigDecimal.valueOf(Float.parseFloat(itemTokens[2]))
                                     .setScale(2, RoundingMode.DOWN);
        int qty = Integer.parseInt(itemTokens[3]);
        return new VendingMachineItem(index, name, price, qty);
    }

    private String marshallVendingMachineItem(VendingMachineItem item) {
        String itemString = "" + item.getIndex();
        itemString += DELIMITER + item.getName();
        itemString += DELIMITER + item.getPrice();
        itemString += DELIMITER + item.getQty();
        return itemString;
    }

    private Map<Change, Integer> unmarshallChange(String changeString) {
        Map<Change, Integer> change;
        String[] changeTokens = changeString.split(DELIMITER);
        change = new HashMap<>();
        change.put(Change.QUARTER, Integer.parseInt(changeTokens[0]));
        change.put(Change.DIME, Integer.parseInt(changeTokens[1]));
        change.put(Change.NICKEL, Integer.parseInt(changeTokens[2]));
        change.put(Change.PENNY, Integer.parseInt(changeTokens[3]));
        return change;
    }

    private String marshallChange(Map<Change, Integer> change) {
        int quarterQty = change.get(Change.QUARTER);
        int dimeQty = change.get(Change.DIME);
        int nickelQty = change.get(Change.NICKEL);
        int pennyQty = change.get(Change.PENNY);
        return quarterQty + DELIMITER + dimeQty + DELIMITER + nickelQty + DELIMITER + pennyQty;
    }

    private void loadVendingMachineData() throws VendingMachineDaoException {
        Scanner inventoryScanner;
        Scanner changeScanner;
        try {
            inventoryScanner = new Scanner(new BufferedReader(new FileReader(VENDING_MACHINE_INVENTORY)));
            changeScanner = new Scanner(new BufferedReader(new FileReader(VENDING_MACHINE_CHANGE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not load vending machine data", e);
        }

        Map<Change, Integer> change = new HashMap<Change, Integer>() {{
            put(Change.QUARTER, 0);
            put(Change.DIME, 0);
            put(Change.NICKEL, 0);
            put(Change.PENNY, 0);
        }};
        Map<Change, Integer> changeInserted = new HashMap<Change, Integer>() {{
            put(Change.QUARTER, 0);
            put(Change.DIME, 0);
            put(Change.NICKEL, 0);
            put(Change.PENNY, 0);
        }};
        if (changeScanner.hasNextLine()) {
            String changeString = changeScanner.nextLine();
            change = unmarshallChange(changeString);
        }
        changeScanner.close();

        String inventoryString;
        List<VendingMachineItem> inventory = new ArrayList<>();
        while (inventoryScanner.hasNextLine()) {
            inventoryString = inventoryScanner.nextLine();
            VendingMachineItem item = unmarshallVendingMachineItem(inventoryString);
            inventory.add(item);
        }
        inventoryScanner.close();

        vendingMachine.setChangeInserted(changeInserted);
        vendingMachine.setChange(change);
        vendingMachine.setInventory(inventory);
    }

    private void writeVendingMachineData() throws VendingMachineDaoException {
        PrintWriter changeWriter;
        PrintWriter inventoryWriter;
        try {
            changeWriter = new PrintWriter(new FileWriter(VENDING_MACHINE_CHANGE));
            inventoryWriter = new PrintWriter(new FileWriter(VENDING_MACHINE_INVENTORY));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not write vending machine data", e);
        }

        String changeString = marshallChange(vendingMachine.getChange());
        changeWriter.println(changeString);
        changeWriter.flush();
        changeWriter.close();

        List<VendingMachineItem> inventory = vendingMachine.getInventory();
        String itemString;
        for (VendingMachineItem item : inventory) {
            itemString = marshallVendingMachineItem(item);
            inventoryWriter.println(itemString);
            inventoryWriter.flush();
        }
        inventoryWriter.close();
    }
}
