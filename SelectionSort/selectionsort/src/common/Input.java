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
 * @author shopp
 */
public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String label) {
        int input;
        while (true) {
            System.out.println(label);
            try {
                input = Integer.parseInt(sc.nextLine().trim());

                if (input <= 0) {
                    System.err.println("Number of range must larger than 0");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format! Must be a positive integer!");
            }
        }
    }
    
    public static int[] genRandomArrayInRange(int range){
        Random random = new Random();
        int[] array = new int[range];
        for (int i = 0; i < range; i++){
            array[i] = random.nextInt(range);
        }
        return array;
    }
}
