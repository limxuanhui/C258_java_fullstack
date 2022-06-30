package com.josephlxh.PizzaOrderApp;
/* Created by limxuanhui on 30/6/22 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

class Pizza {
    private String flavour;
    private float price;

    Pizza(String flavour, float price) {
        this.flavour = flavour;
        this.price = price;
    }

    public String getFlavour() {
        return this.flavour;
    }

    public float getPrice() {
        return this.price;
    }
}

class PizzaMenu {
    private HashMap<Integer, Pizza> menu;

    PizzaMenu(HashMap<Integer, Pizza> menu) {
        this.menu = menu;
    }

    public HashMap<Integer, Pizza> getMenu() {
        return this.menu;
    }
}

class PizzaPriceList {
    private HashMap<Integer, Float> priceList;

    PizzaPriceList(HashMap<Integer, Float> priceList) {
        this.priceList = priceList;
    }

    public HashMap<Integer, Float> getPriceList() {
        return this.priceList;
    }
}

class PizzaForm {
    private HashMap<Integer, Integer> form;

    PizzaForm(HashMap<Integer, Integer> form) {
        this.form = form;
    }

    public HashMap<Integer, Integer> getForm() {
        return this.form;
    }

    public void setQuantity(int id, int qty) {
        this.form.replace(id, qty);
    }
}

class PizzaHouse {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private PizzaMenu pizzaMenu;
    private PizzaForm pizzaForm;

    PizzaHouse(String name) {
        PizzaMenu pizzaMenu = new PizzaMenu(this.createMenu());
        PizzaForm pizzaForm = new PizzaForm(this.createForm());
        this.name = name;
        this.pizzaMenu = pizzaMenu;
        this.pizzaForm = pizzaForm;

        System.out.println("Welcome to " + this.name);
        this.takeOrder();
    }

    public PizzaForm getPizzaForm() {
        return this.pizzaForm;
    }

    private static HashMap<Integer, Pizza> createMenu() {
        HashMap<Integer, Pizza> menu = new HashMap<>();
        menu.put(1, new Pizza("Savoury Pepperoni", 12.9f));
        menu.put(2, new Pizza("Zesty Hawaiian", 9.9f));
        menu.put(3, new Pizza("Wild Pacific Seafood", 14.9f));
        menu.put(4, new Pizza("Cheesy Vegetarian", 11.9f));
        return menu;
    }

    private static HashMap<Integer, Integer> createForm() {
        HashMap<Integer, Integer> form = new HashMap<>();
        form.put(1, 0);
        form.put(2, 0);
        form.put(3, 0);
        form.put(4, 0);
        return form;
    }

    private static int promptQuantity() {
        System.out.println("How many would you like?");
        int qty = promptInteger();
        return qty;
    }

    private static int promptInteger() {
        boolean isValid = false;
        do {
            try{
                String so = scanner.nextLine();
                int option = Integer.parseInt(so);
                return option;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again");
            }
        } while (!isValid);
        return 0;
    }

    private static String promptYesNo() {
        boolean isValid = false;
        do {
            System.out.println("Do you want to carry on?");
            try {
                System.out.println("Y or N?");
                String yesOrNo = scanner.nextLine();
                return yesOrNo;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid response, please try again.");
            }

        } while (!isValid);
        return null;
    }

    private void displayMenu() {
        System.out.println("===== Today's Menu =====");
        this.pizzaMenu.getMenu().forEach((k, v) -> {
            System.out.println("\t" + k + ". " + v.getFlavour() + " - $" + v.getPrice());
        });
        System.out.println("\t9. Checkout");
        System.out.println("\t0. Exit");
    }

    public void takeOrder() {
        boolean continueAdding = true;
        while (continueAdding) {
            this.displayMenu();
            int option = promptInteger();
            switch (option) {
                case 1:
                    int qty = promptQuantity();
                    this.pizzaForm.setQuantity(1, qty);
                    break;
                case 2:
                    qty = promptQuantity();
                    this.pizzaForm.setQuantity(2, qty);
                    break;
                case 3:
                    qty = promptQuantity();
                    this.pizzaForm.setQuantity(3, qty);
                    break;
                case 4:
                    qty = promptQuantity();
                    this.pizzaForm.setQuantity(4, qty);
                    break;
                case 9:
                    this.checkout();
                    break;
                case 0:
                    System.out.println("Bye! We look forward to seeing you at " + this.name + " again!");
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }

            String carryOn = promptYesNo();
            if (carryOn.toLowerCase(Locale.ROOT).charAt(0) == 'n') {
                continueAdding = false;
            }
        }
        this.checkout();
    }

    private void checkout() {
        System.out.println("===== Your Checkout Cart =====");
        this.pizzaForm.getForm().forEach((k, v) -> {
            System.out.println("\t" + this.pizzaMenu.getMenu().get(k).getFlavour() + " - Qty: " + v);
        });
        System.out.println("=== Total ===");
        System.out.println(this.calculateTotalPrice());
    }

    private float calculateTotalPrice() {
        float totalPrice = 0.0f;

        for (Integer i : this.pizzaForm.getForm().keySet()) {
            totalPrice += this.pizzaMenu.getMenu().get(i).getPrice() * this.pizzaForm.getForm().get(i);
        }
        return totalPrice;
    }
}
