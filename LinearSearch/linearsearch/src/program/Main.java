/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import common.Input;
import java.util.Random;

/**
 *
 * @author phuga
 */
public class Main {

    public static void main(String[] args) {
        //1. User enter number of array & search value
        int numberOfArray = Input.getNumberOfRange("Enter number of array:");
        int searchValue = Input.getSearchNumber("Enter search value:");
        //2. Generate random integer in number range for each array element
        int[] randomArrayInRange = generateRandomArrayInRange(numberOfArray);
        //3. Display the array
        displayArray(randomArrayInRange);
        //4. Display the index of search number in array
        linearSearch(randomArrayInRange, searchValue);
    }

    private static int[] generateRandomArrayInRange(int numberOfArray) {
        Random rd = new Random();
        int[] array = new int[numberOfArray];

        for (int i = 0; i < numberOfArray; i++) {
            array[i] = rd.nextInt(numberOfArray);
        }
        return array;
    }

    private static void displayArray(int[] array) {
        System.out.print("The array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.printf("]\n");
    }

    private static void linearSearch(int[] array, int searchValue) {
        int indexSearchValue = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                indexSearchValue = i;
                break;
            }
        }
        if (indexSearchValue == -1) {
            System.err.println("Not found " + searchValue + " in array!");
        } else {
            System.out.println("Found " + searchValue + " at index: " + indexSearchValue);
        }

    }
}
