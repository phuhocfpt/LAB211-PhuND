/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.util.Scanner;
import common.Input;
import controller.Management;

/**
 *
 * @author shopp
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final Management management = new Management();

    public void run() {
        while (true) {
            displayMenu();

            int choice = Input.getInt("Enter your choice:", 1, 5);
            switch (choice) {
                case 1:
                    //create student
                    management.create();
                    break;
                case 2:
                    //find and sort(by name)
                    management.findAndSort();
                    break;
                case 3:
                    //Update/Delete(Semester and Course)
                    management.updateOrDelete();
                    break;
                case 4:
                    //report(print all students)
                    management.report();
                    break;
                case 5:
                    //out program
                    System.out.println("===EXITTING PROGRAM===");
                    return;
            }
        }
    }

    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

}
