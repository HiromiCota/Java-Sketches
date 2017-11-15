package PrimeNumbers;

import javax.swing.JOptionPane;

/**
 *
 * @author Hiromi Cota
 */
public class Calculations {

    static public Boolean isPrime(int testVal) {
        boolean isPrime = true;
        if (testVal > 3) //There's no need to test 1-3
        {
            for (int i = 2; i <= Math.sqrt(testVal) && isPrime == true; i++) {
                int remain = testVal % i;
                System.out.println(testVal + "%" + i + "=" + remain);
                if (testVal % i == 0) {

                    isPrime = false;
                }
            }
        } else if (testVal <= 0) {
            return !isPrime; //Negatives are not prime.
        }
        return isPrime;
    }

    static public void outputIsPrime(Boolean isPrime, int number) {
        displayTextArea.setText(number + " is ");
        if (isPrime == false) {
            displayTextArea.append("NOT ");
        }
        displayTextArea.append("prime!");
    }

    static public void primeFactors() {

    }

    static public void range() {

    }

    // listPrimes();
    // display the first n prime numbers
    static public void listPrimes() {
        String message = "Illegal type--inter an integer >= 1 and < "
                + MAX_INPUT;
        try {
            int max = Integer.parseInt(listAllJTextField.getText());
            if (max < 0 || max > MAX_INPUT) {
                message = "Illegal range--Enter an integer >=1 and < " + MAX_INPUT;
                throw new NumberFormatException();
            }
            int[] primes = new int[max];
            int primeCount = 1;
            int test = 3;
            StringBuffer output = new StringBuffer("The first " + max + " integers are:\n\n2\t");
            while (primeCount < max) {
                if (isPrime(test)) {
                    primes[primeCount] = test;
                    output.append(test);
                    output.append("\t");
                    primeCount++;
                }
                test += 2;
            }
            displayTextArea.setText(output.toString());
        } catch (NumberFormatException numexp) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    message, "Illegal Input", JOptionPane.WARNING_MESSAGE);
            listAllJTextField.requestFocus();
            listAllJTextField.selectAll();
        }
    }

    static public void goldbach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static public void palindrome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static public void emirp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
