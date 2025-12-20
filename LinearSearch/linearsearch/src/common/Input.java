/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Scanner;

/**
 *
 * @author phuga
 */
public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static int getNumberOfRange(String label) {
        String input = "";
        while (true) {
            System.out.println(label);
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.err.println("Input must not empty!");
                continue;
            }
            int validInput = Integer.parseInt(input);
            if (validInput <= 0) {
                System.err.println("Number of range must not <= 0");
                continue;
            }
            return validInput;
        }
    }

    public static int getSearchNumber(String label) {
        String input = "";
        while (true) {
            System.out.println(label);
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.err.println("Input must not empty!");
                continue;
            }
            int validInput = Integer.parseInt(input);
            if (validInput < 0) {
                System.err.println("Search number must not < 0");
                continue;
            }
            return validInput;
        }
    }

}
