/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Random;
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
                System.err.println("Input must > 0");
            }
            return validInput;

        }
    }

    public static int getSearchInput(String label) {
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
                System.err.println("Input must > 0");
            }
            return validInput;

        }
    }

    public static int[] getArrayInRange(int range) {
        Random random = new Random();

        int[] array = new int[range];
        for (int i = 0; i < range; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }
}
