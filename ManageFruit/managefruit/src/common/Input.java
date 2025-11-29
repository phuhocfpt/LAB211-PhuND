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

    public static int getInt(String label, int min, int max) {
        int input;
        while (true) {
            System.out.print(label + " ");
            try {
                input = Integer.parseInt(sc.nextLine().trim());

                if (input < min || input > max) {
                    System.err.println("Input must in range [" + min + ", " + max + "]");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format!");
            }
        }
    }

    public static double getDouble(String label, double min, double max) {
        double input;
        while (true) {
            System.out.print(label + " ");
            try {
                input = Double.parseDouble(sc.nextLine().trim());

                if (input < min || input > max) {
                    System.err.println("Input must in range [" + min + ", " + max + "]");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format!");
            }
        }
    }

    public static String getString(String label) {
        String input;
        while (true) {
            System.out.print(label + " ");

            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input must not empty!");
                continue;
            }
            return input;
        }
    }

    public static char getChoice(String label, String choices) {
        while (true) {
            System.out.print(label + " ");
            String result = sc.nextLine().trim().toUpperCase();

            if (result.length() == 1 && choices.contains(result)) {
                return result.charAt(0);
            }

            System.err.println("Not in valid choice!");
        }
    }
}
