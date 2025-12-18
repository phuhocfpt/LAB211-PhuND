/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import common.Input;

/**
 *
 * @author phuga
 */
public class Main {

    public static void main(String[] args) {
        //1. User enter a number of array and search number.
        int numberOfArray = Input.getNumberOfRange("Enter number of array:");
        int searchNumber = Input.getSearchInput("Enter search number:");
        //2. Generate random integer in number range for each array element
        int[] randomArrayInRange = Input.getArrayInRange(numberOfArray);
        //3. Sort the array
        sortArrayWithBubbleSort(randomArrayInRange);
        displayArray(randomArrayInRange);
        //4. Display index of search number in array
        int indexSearchNumber = binarySearch(randomArrayInRange, searchNumber);
        displayResult(indexSearchNumber, searchNumber);
    }

    private static void sortArrayWithBubbleSort(int[] array) {
        int length = array.length;

        //1st loop for loop from index 0 -> last(length - 1)
        for (int i = 0; i < length - 1; i++) {
            //2nd loop for the element what larger than next one its. 
            //do swap task
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int binarySearch(int[] array, int searchNumber) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == searchNumber) {
                return mid;
            }

            if (array[mid] > searchNumber) {
                //on half of left array
                high = mid - 1;
            }
            if (array[mid] < searchNumber) {
                //on half of right array
                low = mid + 1;
            }
        }
        return -1;
    }

    private static void displayArray(int[] array) {
        System.out.print("Sorted array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }

    private static void displayResult(int indexSearchNumber, int searchNumber) {
        if (indexSearchNumber == -1) {
            System.err.println("Not found " + searchNumber + " in array!");
            return;
        }
        if (indexSearchNumber != -1) {
            System.out.println("Found " + searchNumber + " at index: " + indexSearchNumber);
        }
    }
}
