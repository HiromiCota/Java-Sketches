package Approximator;

/**
 *
 * @author 980453413
 */
public class Approximator {

    static public double calcEFactorial(int precision) {
        double output;
        if (precision == 0) {
            return 1.0;
        }
        output = (double) ((1.0 / factorial(precision)) + calcEFactorial(precision - 1));
        System.out.println((double) (1.0 / factorial(precision)));
        return (output);
    }

    static public long factorial(int length) {
        // Exceeds long's limits at length = 66
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
        for (int i = 1; i < precision; i++) {
            if (i == 1) {
                output *= num / denom;
            } else if (i % 2 == 0) {
                denom += 2.0;
                output *= num / denom;
            } else {
                num += 2.0;
                output *= num / denom;
            }
        }
        return output;
    }

    static public double calcPiGL(int precision) {
        double output = 1.0, num = 1.0, denom = 3.0;
        for (int i = 2; i <= precision; i++) {
            num = (Math.pow(-1.0, i + 1.0));
            denom = (2.0 * i - 1.0);
            output += (num / denom);
        }
        return 4 * output;
    }

}
