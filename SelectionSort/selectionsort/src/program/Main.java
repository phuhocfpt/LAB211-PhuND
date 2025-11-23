/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import common.Input;

/**
 *
 * @author shopp
 */
public class Main {

    public static void main(String[] args) {
        //1. Require user input positive integer(number range)
        int numberOfRange = Input.getInt("Enter number of array:");
        //2. Generate random integer in number range for each array element
        int[] randomArrayInRange = Input.genRandomArrayInRange(numberOfRange);
        //3. Display array before and after sorting
        displayArray(randomArrayInRange, "Unsorted array:");
        selectionSort(randomArrayInRange);
        displayArray(randomArrayInRange, "Sorted array:");
    }

    public static void displayArray(int[] array, String label) {
        System.out.print(label + " [");

        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.printf("]\n");
    }

    public static void selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] < min) {
                    minIndex = j;
                    min = array[j];
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }
    }
}
