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
    public final int fullPrice = 0, childPrice = 1, seniorPrice = 2, matineePrice = 3;
    int ticketID;
    public final static int TYPES_OF_TICKETS = 4;
    public final static Price[] PRICE_LIST = {Price.FULLPRICE, Price.CHILD, Price.SENIOR, Price.MATINEE};
    int[] quantity = new int[TYPES_OF_TICKETS];
    Time thisTime;
    Price thisPrice;
    String thisFilm;
    int filmID;

    Ticket(int ID, Time timeOfShow, String title, int newFilmID, int[] number) {
        ticketID = ID;
        thisTime = timeOfShow;        
        thisFilm = title;
        filmID = newFilmID;
        quantity = number;
    }    
    
    public static Price stringToPrice(String input){
        switch(input)
        {
            case"FULLPRICE":
                return Price.FULLPRICE;
            case"CHILD":
                return Price.CHILD;
            case"SENIOR":
                return Price.SENIOR;
            default:
                return Price.MATINEE;
        }
    }
    public Ticket() {
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public void setThisTime(Time thisTime) {
        this.thisTime = thisTime;
    }

    public void setThisPrice(Price thisPrice) {
        this.thisPrice = thisPrice;
    }

    public void setThisFilm(String thisFilm) {
        this.thisFilm = thisFilm;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public Time getTime() {
        return thisTime;
    }

    public String getDiscount() {
        return thisPrice.toString();
    }

    public double getPrice(Price price) {
        switch (price) {
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
    
    public int priceToInt(Price price){
        switch(price)
        {
            case FULLPRICE:
                return fullPrice;
            case CHILD:
                return childPrice;
            case SENIOR:
                return seniorPrice;
            case MATINEE:
                return matineePrice;
            default:
                return matineePrice;
        }
    }
    
    public int[] getQuantity(){
        return quantity;
    }
    
    public int getTotalQuantity(){
        int output = 0;
        for (int i = 0; i < TYPES_OF_TICKETS;i++)
        {
            output+= quantity[i];
        }
        return output;
    }
    
    public int getQuantity(Price price){        
        return quantity[priceToInt(price)];
    }
    public int getFilmID(){
        return filmID;
    }
    
    public double getSubtotal(){
        double output = 0.0;
        for (int i = 0; i < TYPES_OF_TICKETS; i++)
        {
            output += quantity[i] * getPrice(PRICE_LIST[i]);
        }
        return output;
    }
    
    public String quantityToString(){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < TYPES_OF_TICKETS; i++)
        {
            output.append(Integer.toString(quantity[i]));
            if (i != TYPES_OF_TICKETS -1)
                output.append(" ");
        }
        return output.toString();
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
    public Boolean updateQuantity(int[] number)
    {
        for (int i = 0; i < TYPES_OF_TICKETS; i++)
        {
            if (quantity[i] + number[i] >= 0){
                quantity[i] += number[i];                
            }
            else
                return false;
        }        
        return true;
    }
    
    
}
