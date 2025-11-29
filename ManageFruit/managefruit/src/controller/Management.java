/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Input;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import object.Fruit;
import object.Order;

/**
 *
 * @author phuga
 */
public class Management {

    private ArrayList<Fruit> fruitList;
    private Hashtable<String, ArrayList<Order>> ordersHashtable;

    public Management() {
        fruitList = new ArrayList<>();
        ordersHashtable = new Hashtable<>();
    }

    private Fruit findFruitById(String id) {
        for (Fruit f : fruitList) {
            if (f.getId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }

    //function 1: create fruit
    public void create() {
        System.out.println("----- CREATE -----");
        while (true) {
            String fruitId = Input.getString("Enter New Fruit ID:").toUpperCase();
            Fruit createFruit = findFruitById(fruitId);

            //check list null?
            if (fruitList == null) {
                System.err.println("Fruit list is null!");
                continue;
            }

            //check existe(Must not exsited)
            if (createFruit != null) {
                System.err.println("ID is exsited!");
                continue;
            }

            //if not existed, take all i4 of fruit
            String fruitName = Input.getString("Enter New Fruit Name:");
            int quantity = Input.getInt("Enter New Fruit Quantity:", 1, Integer.MAX_VALUE);
            double price = Input.getDouble("Enter New Fruit Price:", 0.1, Double.MAX_VALUE);
            String origin = Input.getString("Enter New Fruit Origin:");

            fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            System.out.println("ADDED SUCCESSFULLY!!!!!!!!");

            if (fruitList.size() >= 3) {
                char choice = Input.getChoice("Do you want to continue(Y|N):", "YN");

                if (choice == 'N') {
                    break;
                }
            }
        }

    }

    //function 3: Shopping
    public void shopping() {
        System.out.println("----- SHOPPING -----");

        if (fruitList.isEmpty()) {
            System.err.println("Nothing In Store!");
            return;
        }

        //temp cart
        ArrayList<Order> cart = new ArrayList<>();

        while (true) {
            //only print fruit has quantity > 0
            //create a arraylist save available fruit
            ArrayList<Fruit> availableFruitList = new ArrayList<>();

            for (Fruit f : fruitList) {
                if (f.getQuantity() > 0) {
                    availableFruitList.add(f);
                }
            }

            if (availableFruitList.isEmpty()) {
                System.err.println("All fruit are sold out!");
                return;
            }

            //print available list of fruit
            System.out.println("\n--- List of Fruit ---");
            System.out.printf("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ | [Stock] |\n");
            for (int i = 0; i < availableFruitList.size(); i++) {
                Fruit f = availableFruitList.get(i);
                System.out.printf("| %-10d | %-16s | %-12s | %-9.1f$ | (%-5d)\n",
                        (i + 1), f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
            } //done print list of fruit

            int itemChoice = Input.getInt("Enter item you want to buy:", 1, fruitList.size());

            //The fruit they choose(index need - 1)
            Fruit chooseFruit = availableFruitList.get(itemChoice - 1);

            System.out.println("You selected: " + chooseFruit.getName());

            int stockQuantity = chooseFruit.getQuantity();

            int buyQuantity = Input.getInt("Please input quantity(Available: " + stockQuantity + "):", 1, chooseFruit.getQuantity());

            //check quantity buy > stock ?
            if (buyQuantity > stockQuantity) {
                System.err.println("Available of " + chooseFruit.getName() + " is only: " + stockQuantity);
                continue; //return page to print list of available fruit
            }

            chooseFruit.setQuantity(stockQuantity - buyQuantity);
            System.out.println("Update stock quantity of " + chooseFruit.getName() + ": " + chooseFruit.getQuantity());
            //create a order
            Order newItem = new Order(chooseFruit.getName(),
                    buyQuantity, chooseFruit.getPrice());

            //variable for check duplicate item that selected
            //if duplicate then just add to selected fruit's quantity for not orderItem is redurant
            boolean itemExisted = false;

            for (Order item : cart) {
                if (item.getFruitName().equalsIgnoreCase(chooseFruit.getName())) {
                    //== then set quantity
                    item.setFruitQuantity(item.getFruitQuantity() + chooseFruit.getQuantity());

                    itemExisted = true;
                    break;
                }
            }

            if (itemExisted == false) {
                cart.add(newItem);
            }

            System.out.println("Item added to cart.");

            char choice = Input.getChoice("Do you want to order now? (Y/N)", "YN");

            if (choice == 'Y') {
                break;
            }
        }

        //if choose Y
        //check cart(not shopping)
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Returning to menu!");
            return;
        }

        //print order(product|quantity|price|amount)
        System.out.println("----- YOUR ORDER -----");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Product", "Quantity", "Price", "Amount");

        double total = 0;

        //calculate total
        for (Order item : cart) {
            double amount = item.getAmount();
            System.out.printf("%-10s | %-10d | %-10.1f$ | %-10.1f$\n", item.getFruitName(),
                    item.getFruitQuantity(), item.getFruitPrice(), amount);
            total += amount;
        }
        //and print total amount.
        System.out.println("Total: " + total + "$");

        //final: enter name => return to menu
        String customerName = Input.getString("Enter your name:");

        //use Hashtable to save order
        //if customer has name duplicated, the new order will override this old
        ordersHashtable.put(customerName, cart);
        System.out.println("Thank you for your purchase!");
    }

    //function 2: View order
    public void viewOrder() {
        //use orderHashTable print all pair key and value

        System.out.println("------- VIEW ORDER -------");
        if (ordersHashtable.isEmpty()) {
            System.err.println("No order here!");
            return;
        }

        for (Map.Entry<String, ArrayList<Order>> entry : ordersHashtable.entrySet()) {
            String customerName = entry.getKey();
            ArrayList<Order> cart = entry.getValue();

            double total = 0;
            // loop through each item in the cart
            for (Order item : cart) {
                System.out.println(customerName);
                double amount = item.getAmount();
                System.out.printf("%-9s | %-8d | %-5.1f$ | %.1f$\n",
                        item.getFruitName(), item.getFruitQuantity(), item.getAmount(), amount);
                total += amount;
            }

            System.out.println("Total: " + total + "$");
        }
    }

}
