package PracticeFinal;


import java.util.Random;
import java.util.Scanner;

public class FinalExamQuestion52 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of random integers desired: ");
        int numInt = keyboard.nextInt();
        int randInts[] = new int[numInt];
        Random random = new Random();
        for (int i = 0; i < numInt; i++) {
            randInts[i] = random.nextInt(28) - 10;
            System.out.print("" + randInts[i] + "\t");
            if (i % 10 == 9) {
                System.out.print("\n");
            }
        }

    }

}
