package Approximator;

/**
 *
 * @author 980453413
 */
public class Approximator {

    static final int STACK_LIMIT = 5000;

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

    static public double approximatePi(int precision) {
        double output;
        output = 2.0 * flipFlopPi(precision);
        System.out.println("Via flipFlop: " + output);
        output = calcPiGL(precision);
        System.out.println("Via Gregory-Leibniz formula: " + output);
        return output;
    }

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

    static public double calcPiGL(int precision) {
        double output = 0.0, num = 1.0, denom = 1.0;
        for (int i = 1; i <= precision; i++) {
            denom = (2.0 * i - 1.0);
            output += (num / denom);
            //System.out.println("" + num + "/" + denom + "=" + output);
            num *= -1.0;
        }
        return 4 * output;
    }

}
