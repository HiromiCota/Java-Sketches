package Movie;

/**
 *
 * @author Hiromi Cota
 */
public class Ticket {

    public final double DISCOUNT = 5.50;
    public final double NORMAL = 9.00;

    public enum Price {
        FULLPRICE, CHILD, SENIOR, MATINEE
    }
    ShowTime thisTime;
    Price thisPrice;

    Ticket(Price price, ShowTime showTime) {
        thisTime = showTime;
        thisPrice = price;
    }

    public ShowTime getTime() {
        return thisTime;
    }

    public String getDiscount() {
        return thisPrice.toString();
    }

    public double getPrice() {
        switch (thisPrice) {
            case FULLPRICE:
                return NORMAL;
            case CHILD:
                return DISCOUNT;
            case SENIOR:
                return DISCOUNT;
            case MATINEE:
                return DISCOUNT;
            default:
                return DISCOUNT;
        }
    }
}
