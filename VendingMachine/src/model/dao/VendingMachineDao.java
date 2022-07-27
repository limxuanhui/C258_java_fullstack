package model.dao;
/* Created by limxuanhui on 27/6/22 */

import model.dto.Change;
import model.dto.VendingMachine;
import model.dto.VendingMachineItem;

import java.util.Map;

public interface VendingMachineDao {
    VendingMachine getVendingMachine() throws VendingMachineDaoException;
    void vendItem(VendingMachineItem item, Map<Change, Integer> payment);
    Map<Change, Integer> dispenseChange();
}
