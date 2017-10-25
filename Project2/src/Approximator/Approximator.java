package Approximator;

/**
 *
 * @author 980453413
 */
public class Approximator {

    static public double approximateEuler(int precision) {
        double output;
        if (precision == 0) {
            return 1.0;
        }
        output = (double) ((1.0 / factorial(precision)) + approximateEuler(precision - 1));
        System.out.println((double) (1.0 / factorial(precision)));
        return (output);
    }

    static public long factorial(int length) {
        long output;
        if (length <= 0) {
            return 1;
        }
        output = length * factorial(length - 1);
        //System.out.println(output);
        return (output);
    }

    static public double approximatePi(int precision) {
        double output = 3.0;

        return output;
    }
}
