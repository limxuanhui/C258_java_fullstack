package L3;
/* Created by limxuanhui on 8/6/22 */

import java.util.Scanner;

public class L3WindowMaster {
    /*
        It must prompt the user for the height of the window (in feet).
        It must prompt the user for the width of the window (in feet).
        It must calculate and display the area of the window.
        It must calculate and display the perimeter of the window.
        Based on the area and perimeter, it must calculate the total cost of the window.
        The glass for the windows cost $3.50 per square foot.
        The trim for the windows cost $2.25 per linear foot.
    */

    public static Scanner scanner = new Scanner(System.in);


    public static int intPrompt(String item) {
        boolean isValid = false;

        do {
            try {
                System.out.println("Please enter the " + item + ":" );
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                return number;
            } catch(NumberFormatException ex) {
                System.out.println("That is not a valid " + item + " value! Please enter an integer!");
            }
        } while(!isValid);
        return -1;
    }

    public static float floatPrompt(String item) {
        boolean isValid = false;

        do {
            try {
                System.out.println("Please enter the " + item + ":" );
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
                return number;
            } catch(NumberFormatException ex) {
                System.out.println("That is not a valid " + item + " value! Please enter a floating point number!");
            }
        } while(!isValid);
        return -1;
    }

    public static void main(String[] args) {
        float height;
        float width;
        float areaOfWindow;
        float perimeterOfWindow;
        float cost;
        float glassCostPerSqFt;
        float trimCostPerFt;
        float costPerWindow;
        int numberOfWindows;

        // get user inputs
        height = floatPrompt("window height");
        width = floatPrompt("window width");
        glassCostPerSqFt = floatPrompt("glass cost per sq ft");
        trimCostPerFt = floatPrompt("trim cost per ft");
        numberOfWindows = intPrompt("number of windows");

        // calculate area of window, perimeter of window, cost
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        costPerWindow = glassCostPerSqFt * areaOfWindow + trimCostPerFt * perimeterOfWindow;
        cost = numberOfWindows * costPerWindow;

        // display the results to the user
        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Cost per window = " + costPerWindow);
        System.out.println("Number of windows = " + numberOfWindows);
        System.out.println("Total Cost = " + cost);
    }
}
