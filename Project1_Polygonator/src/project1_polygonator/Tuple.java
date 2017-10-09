package project1_polygonator;

/**
 *
 * @author 980453413
 */
public class Tuple {

    public int sides;
    public double length;

    public Tuple() {
        sides = 0;
        length = 0.0;
    }

    public Tuple(int incomingSides, double incomingLength) {
        sides = incomingSides;
        length = incomingLength;
    }

    public void setSides(int input) {
        this.sides = input;
    }

    public void setLength(double input) {
        this.length = input;
    }

}
