package bubblesort;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shopp
 */
import common.Input;

public class Main {

    public static void main(String[] args) {
        //1. User input positive decimal number
        int numberOfRange = Input.getInt("Enter number of array:");
        //2. Generate random integer in number range for each array element
        int[] randomArrayInRange = Input.genRandomArrayInRange(numberOfRange);
        //3. Display array before and after sorting
        displayArray(randomArrayInRange, "Unsorted array:");
        bubbleSort(randomArrayInRange);
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

    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    //temp la cai nho
                    //can doi cai temp thanh array[j]
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
