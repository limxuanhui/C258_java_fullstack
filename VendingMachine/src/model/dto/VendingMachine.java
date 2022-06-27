package model.dto;
/* Created by limxuanhui on 26/6/22 */

import java.util.List;
import java.util.Map;

public class VendingMachine {
    

    public VendingMachine(List<VendingMachineItem> inventory, Map<Change, Integer> change) {
        this.inventory = inventory;
        this.change = change;
    }

    public List<VendingMachineItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<VendingMachineItem> inventory) {
        this.inventory = inventory;
    }

    public Map<Change, Integer> getChange() {
        return change;
    }

    public void setChange(Map<Change, Integer> change) {
        this.change = change;
    }


}
