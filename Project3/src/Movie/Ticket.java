package Movie;

import java.sql.Time;

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
    int ticketID;
    int quantity;
    Time thisTime;
    Price thisPrice;
    String thisFilm;
    int filmID;

    Ticket(int ID, Price price, Time timeOfShow, String title, int newFilmID, int number) {
        ticketID = ID;
        thisTime = timeOfShow;
        thisPrice = price;
        thisFilm = title;
        filmID = newFilmID;
        quantity = number;
    }
    Ticket(int ID, Price price, Time timeOfShow, String title,int newFilmID ) {
        ticketID = ID;
        thisTime = timeOfShow;
        thisPrice = price;
        thisFilm = title;
        filmID = newFilmID;
        quantity = 1;
    }

    public Time getTime() {
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
    public String getTitle(){
        return thisFilm;
    }
    
    public int getQuantity(){
        return quantity;
    }
    public int getFilmID(){
        return filmID;
    }
    
    public double getSubtotal(){
        return quantity * getPrice();
    }
    /**
     * updateQuantity()
     * @param number - The number of tickets to add (or subtract)
     * ***number CAN be negative***
     * 
     * NOTE: Does NOT validate if number is fewer than ShowTime.TicketsRemaining
     * 
     * @return Returns success or failure
     */
    public Boolean updateQuantity(int number)
    {
        if (quantity + number >= 0){
            quantity += number;
            return true;
        }
        return false;
    }
    
}
