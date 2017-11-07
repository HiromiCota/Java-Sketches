package Approximator;

/**
 * class Approximator 
 * Description: Calculations class for ApproximatorGUI.java
 * 
 * WARNING: NO main()! MUST BE INVOKED BY ANOTHER CLASS!
 *
 * @author Hiromi Cota
 */
public class Approximator {

    static final int STACK_LIMIT = 5000;

    /**
    * Function: calcEFactorial()
    * @author: Hiromi Cota
    * Calculates e via a recursive call to itself and factorial()
    * 
    * Dependencies:
    * factorial()
    * 
    * @return output
    * @param precision
    */
    static public double calcEFactorial(int precision) {
        double output = 0.0;
        if (precision == 0) {
            return 1.0;
        }
        if (precision >= STACK_LIMIT) {
            precision = STACK_LIMIT;
        }
        output = (double) ((1.0 / factorial(precision)) + calcEFactorial(precision - 1));

        System.out.println("Precision: " + precision);

        return (output);
    }
    /**
    * Function: factorial()
    * @author: Hiromi Cota
    * Calculates the requested factorial via a recursive call to itself.
    * 
    * WARNING: Hardcoded to cap precision at 65! 
    * (66! causes a overflow of the long class)    * 
    * 
    * Dependencies:
    * factorial()
    * 
    * @return output
    * @param length
    */
    static public long factorial(int length) {
        // Exceeds long's limits at length = 66
        if (length > 65) {
            length = 65;
        }
        long output;
        if (length <= 1) {
            return 1;
        }
        output = length * factorial(length - 1);
        return (output);
    }
    /**
    * Function: approximatePi()
    * @author: Hiromi Cota
    * Calculates pi via calls to flipFlopPi() and calcPiGL()    
    * 
    * Dependencies:
    * flipFlopPi()
    * calcPiGL()
    * 
    * @return output
    * @param precision
    */
    static public double approximatePi(int precision) {
        double output;
        output = 2.0 * flipFlopPi(precision);
        System.out.println("Via flipFlop: " + output);
        output = calcPiGL(precision);
        System.out.println("Via Gregory-Leibniz formula: " + output);
        return output;
    }
    /**
    * Function: flipFlopPi()
    * @author: Hiromi Cota
    * Calculates pi via a for loop
    * 
    * @return output
    * @param precision
    */
    static public double flipFlopPi(int precision) {
        double output = 1.0, num = 2.0, denom = 1.0;
        for (int i = 2; i <= precision; i++) {
            if (i % 2 == 1) {
                num += 2.0;
            } else {
                denom += 2.0;
            }
            output *= (num / denom);
        }
        return 4 * output;
    }
    /**
    * Function: calcPiGL()
    * @author: Hiromi Cota
    * Calculates pi via Gregory-Leibniz formula
    * 
    * @return output
    * @param precision
    */
    static public double calcPiGL(int precision) {
        double output = 0.0, num = 1.0, denom = 1.0;
        for (int i = 1; i <= precision; i++) {
            denom = (2.0 * i - 1.0);
            output += (num / denom);            
            num *= -1.0;
        }
        return 4 * output;
    }

}
