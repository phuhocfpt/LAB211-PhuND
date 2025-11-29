/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import common.Input;
import controller.Management;

/**
 *
 * @author phuga
 */
public class Menu {

    private static Management management = new Management();

    public void run() {
        while (true) {
            displayMenu();

            int chocie = Input.getInt("Enter your choice:", 1, 4);
            switch (chocie) {
                case 1:
                    //create fruit
                    management.create();
                    break;
                case 2:
                    //view order(history)
                    management.viewOrder();
                    break;
                case 3:
                    //shopping
                    management.shopping();
                    break;
                case 4:
                    //exit
                    System.out.println("===EXITTING PROGRAM===");
                    return;
            }
        }
    }

    public void displayMenu() {
        System.out.println("===== FRUIT SHOP SYSTEM =====");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping(for buyer)");
        System.out.println("4. Exit");
    }
}
