package model.dto;
/* Created by limxuanhui on 26/6/22 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachine {
    private final int COLUMN = 3;
    private final int ROWS = 4;
    private final int MAX_ITEM_WIDTH = 20;
    private final int VENDING_MACHINE_WIDTH = MAX_ITEM_WIDTH * COLUMN + COLUMN + 1;
    private List<VendingMachineItem> inventory;
    private Map<Change, Integer> change;
    private Map<Change, Integer> changeInserted;

    public List<VendingMachineItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<VendingMachineItem> inventory) {
        this.inventory = inventory;
    }

    public Map<Change, Integer> getChange() {
        return change;
    }

    public BigDecimal getSumOfCoins(Map<Change, Integer> coins) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Change coinType : coins.keySet()) {
            sum = sum.add(BigDecimal.valueOf(coinType.getV() * coins.get(coinType))
                     .setScale(2, RoundingMode.DOWN));
        }
        return sum;
    }

    public void setChange(Map<Change, Integer> change) {
        this.change = change;
    }

    public void setChangeInserted(Map<Change, Integer> changeInserted) {
        this.changeInserted = changeInserted;
    }

    private String generateItemNameString(String itemName, int maxLength) {
        int itemNameLength = itemName.length();
        if (itemNameLength > maxLength) {
            return itemName.substring(0, maxLength);
        } else {
            int leftSpaceLength = (maxLength - itemNameLength) / 2;
            int rightSpaceLength = itemNameLength % 2 == 0 ? leftSpaceLength : leftSpaceLength + 1;
            char[] leftSpace = new char[leftSpaceLength];
            char[] rightSpace = new char[rightSpaceLength];
            Arrays.fill(leftSpace, ' ');
            Arrays.fill(rightSpace, ' ');
            String leftEmptySpace = new String(leftSpace);
            String rightEmptySpace = new String(rightSpace);
            return leftEmptySpace + itemName + rightEmptySpace;
        }
    }

    private List<String> generateAllItemNameStrings() {
        List<String> itemNames = inventory.stream()
                                          .map(item -> generateItemNameString(item.getName(), MAX_ITEM_WIDTH))
                                          .collect(Collectors.toList());
        return itemNames;
    }

    private String generateItemPriceButtonString(String index, BigDecimal price, int maxLength) {
        String itemPriceButtonContent = "(" + index + ") $" + price;
        int itemPriceButtonContentLength = itemPriceButtonContent.length();
        int leftSpaceLength = (maxLength - itemPriceButtonContentLength) / 2;
        int rightSpaceLength = itemPriceButtonContentLength % 2 == 0 ? leftSpaceLength : leftSpaceLength + 1;
        char[] leftSpace = new char[leftSpaceLength];
        char[] rightSpace = new char[rightSpaceLength];
        Arrays.fill(leftSpace, ' ');
        Arrays.fill(rightSpace, ' ');
        String leftEmptySpace = new String(leftSpace);
        String rightEmptySpace = new String(rightSpace);
        return leftEmptySpace + itemPriceButtonContent + rightEmptySpace;

    }

    private List<String> generateAllItemPriceButtonStrings() {
        List<String> itemPriceButtons = inventory.stream()
                                                 .map(item -> {
                                                     String index = item.getQty() > 0 ? "" + item.getIndex() : "X";
                                                     return generateItemPriceButtonString(index, item.getPrice(), MAX_ITEM_WIDTH);
                                                 })
                                                 .collect(Collectors.toList());
        return itemPriceButtons;
    }

    private List<String> generateStructure() {
        List<String> structure = new ArrayList<>();
        char[] topBarChars = new char[VENDING_MACHINE_WIDTH];
        char[] bottomBarChars = new char[VENDING_MACHINE_WIDTH];
        char[] shelfChars = new char[VENDING_MACHINE_WIDTH];
        Arrays.fill(topBarChars, '=');
        Arrays.fill(bottomBarChars, '=');
        Arrays.fill(shelfChars, '-');
        String topBar = (new String(topBarChars)) + "\n";
        String bottomBar = (new String(bottomBarChars)) + "\n";
        String shelf = (new String(shelfChars)) + "\n";
        structure.add(topBar);
        structure.add(shelf);
        structure.add(bottomBar);
        return structure;
    }

    @Override
    public String toString() {
        List<String> structure = generateStructure();
        List<String> itemNames = generateAllItemNameStrings();
        List<String> itemPriceButtons = generateAllItemPriceButtonStrings();

        int maxItemNameLength = inventory.stream().mapToInt(i -> i.getName().length()).max().getAsInt();

        String row1Names = "|" + itemNames.get(0) + "|" + itemNames.get(1) + "|" + itemNames.get(2) + "|\n";
        String row1PriceButtons = "|" + itemPriceButtons.get(0) + "|" + itemPriceButtons.get(1) + "|" + itemPriceButtons.get(2) + "|\n";
        String row2Names = "|" + itemNames.get(3) + "|" + itemNames.get(4) + "|" + itemNames.get(5) + "|\n";
        String row2PriceButtons = "|" + itemPriceButtons.get(3) + "|" + itemPriceButtons.get(4) + "|" + itemPriceButtons.get(5) + "|\n";
        String row3Names = "|" + itemNames.get(6) + "|" + itemNames.get(7) + "|" + itemNames.get(8) + "|\n";
        String row3PriceButtons = "|" + itemPriceButtons.get(6) + "|" + itemPriceButtons.get(7) + "|" + itemPriceButtons.get(8) + "|\n";
        String row4Names = "|" + itemNames.get(9) + "|" + itemNames.get(10) + "|" + itemNames.get(11) + "|\n";
        String row4PriceButtons = "|" + itemPriceButtons.get(9) + "|" + itemPriceButtons.get(10) + "|" + itemPriceButtons.get(11) + "|\n";

        String amountInserted = "||| Amount Inserted | $" + getSumOfCoins(changeInserted) + " ||| Change | $" + getSumOfCoins(change) + "|\n";

        return structure.get(0) + row1Names + row1PriceButtons + structure.get(1) + row2Names + row2PriceButtons + structure.get(1)
                + row3Names + row3PriceButtons + structure.get(1) + row4Names + row4PriceButtons + structure.get(2) + structure.get(1) + amountInserted + structure.get(2);
    }
}
