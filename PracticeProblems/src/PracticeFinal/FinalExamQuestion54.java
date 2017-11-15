package PracticeFinal;

import java.util.Random;
import java.util.Scanner;

public class FinalExamQuestion54 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of random integers in the range [-21, 69] you want: ");
        int randomInts = keyboard.nextInt();
        Random rand = new Random();
        int[] randNums = new int[randomInts];
        for (int i = 0; i < randomInts; i++) {
            randNums[i] = rand.nextInt(91) - 21;
            if (i % 10 != 9) {
                System.out.print(randNums[i] + "\t");
            } else {
                System.out.print(randNums[i] + "\n");
            }
        }
        System.out.print("Enter number to search array for: ");
        int key = keyboard.nextInt();
        int indexFound = linearSearch(key, randNums);
        if (indexFound == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key found at position " + indexFound);
        }
    }

    private static int linearSearch(int key, int[] randNums) {
        for (int i = 0; i < randNums.length; i++) {
            if (randNums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int key, int[] randNums) {
        boolean found = false;
        int index, low, high;
        index = -1;
        low = 0;
        high = randNums.length - 1;
        while (low <= high) {
            index = (low + high) / 2;
            if (randNums[index] == key) {
                found = true;
            } else if (key < randNums[index]) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        return index;
    }

    private static void selectionSort(int[] array) {
        int low = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < low) {
                    low = j;
                }
            }
            swap(array, low, i);
        }
    }

    private static void swap(int[] array, int low, int i) {
        int temp = array[low];
        array[low] = array[i];
        array[i] = temp;
    }

}
