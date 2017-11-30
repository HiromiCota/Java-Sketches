package Movie;

import java.util.ArrayList;

/**
 * File: Cart.java
 * 
 * Contains:
 *  Cart class - contains Ticket objects to be sold
 *  constants:
 *      TAX_RATE
 *  methods:
 *      addTicket - Add Ticket object to Cart
 *      findFilmID - Locate index of a Ticket by its FilmID
 *      removeTicket(2 methods) - Remove a Ticket from the Cart
 *      getQuantity - Determine number of Tickets in Cart
 *      clear - Remove ALL Tickets from Cart
 *      getSubtotal - Get total before tax
 *      getTotal - Get total with tax
 *      isEmpty - Determine if the Cart is empty
 *      get - Get a specific Ticket object in the Cart
 *      size - Get the number of Ticket objects in the Cart
 * @author Hiromi Cota
 */
public class Cart {
    //Class level constants
    final double TAX_RATE = 0.089;
    
    //Class level variables
    ArrayList<Ticket> TicketsInCart;    
    double total;    

    //Default Constructor 
    public Cart() {
    }
    
    //Full Constructor
    public Cart(ArrayList<Ticket> TicketsInCart, double total) {
        this.TicketsInCart = TicketsInCart;
        this.total = total;
    }
    /**
     * Checks to see if a Ticket object for the same Film already exists.
     * If so, it adds the quantities together.
     * If not, it just adds the new Ticket to the Cart.
     * 
     * @param ticket 
     */
    public void addTicket(Ticket ticket) {
        int index = findFilmID(ticket.getFilmID());
        if (index != -1) {
            TicketsInCart.get(index).updateQuantity(ticket.getQuantity());
        } else {
            TicketsInCart.add(ticket);            
        }
    }

    public int findFilmID(int searchID){
        for (int i = 0; i < TicketsInCart.size();i++){
            if (TicketsInCart.get(i).getFilmID() == searchID)
                return i;
        }
        return -1;
    }

    public int removeTicket(int filmID, int[] quantity) {
        int index = -1;
        if (isEmpty())
            return index; //If the ArrayList is empty, we can just stop.
        index = findFilmID(filmID); //Find the ticket
        if (index == -1) {
            return index; //Failure. No such ticket
        }
        int[] available = TicketsInCart.get(index).getQuantity();
        int output = 0;
        for (int i = 0; i < Ticket.TYPES_OF_TICKETS; i++)
        {
            if (quantity[i] > available[i])
                output = -2; //Failure. Not enough tickets.
            else if (quantity[i] < available[i])
            {
                quantity[i] = (-1 * quantity[i]);
                output = 1; //This tells us that there is at least one more left
            } else {
                quantity[i] = (-1 * quantity[i]);            
            } 
            if (output == 0) //This means there are no more left. Drop the Ticket
                removeTicket(filmID);     
            else
            {
                TicketsInCart.get(index).updateQuantity(quantity);
            }
        }
        return output;
    }

    public void removeTicket(int filmID) {
        int index = findFilmID(filmID);
        TicketsInCart.remove(index);        
    }
    
    public int[] getQuantity(int index) {
        return TicketsInCart.get(index).getQuantity();
    }

    public void clear() {        
        TicketsInCart.removeAll(TicketsInCart);
    }

    public double getSubtotal() {
        total = 0.0;
        for (int i = 0; i <= TicketsInCart.size(); i++) {
            total += TicketsInCart.get(i).getSubtotal();
        }
        return total;
    }

    public double getTotal() {
        total += total * TAX_RATE;
        return total;
    }

    public Boolean isEmpty() {
        return TicketsInCart.isEmpty();
    }

    public Ticket get(int index) {
        return TicketsInCart.get(index);
    }

    public int size() {
        return TicketsInCart.size();
    }
}
