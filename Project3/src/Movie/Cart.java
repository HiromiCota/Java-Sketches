package Movie;

import java.util.ArrayList;

/**
 * File: Cart.java
 *
 * Contains: Cart class - contains Ticket objects to be sold constants: TAX_RATE
 * methods: addTicket - Add Ticket object to Cart findFilmID - Locate index of a
 * Ticket by its FilmID removeTicket(2 methods) - Remove a Ticket from the Cart
 * getQuantity - Determine number of Tickets in Cart clear - Remove ALL Tickets
 * from Cart getSubtotal - Get total before tax getTotal - Get total with tax
 * isEmpty - Determine if the Cart is empty get - Get a specific Ticket object
 * in the Cart size - Get the number of Ticket objects in the Cart
 *
 * @author Hiromi Cota
 */
public class Cart {

    //Class level constants
    final double TAX_RATE = 0.089;

    //Class level variables
    ArrayList<Ticket> TicketsInCart;
    double total;

    /**
     * Default Cart constructor
     */
    public Cart() {
    }

    /**
     * Cart constructor
     *
     * @param TicketsInCart
     * @param total
     */
    public Cart(ArrayList<Ticket> TicketsInCart, double total) {
        this.TicketsInCart = TicketsInCart;
        this.total = total;
    }

    /**
     * Checks to see if a Ticket object for the same Film already exists. If so,
     * it adds the quantities together. If not, it just adds the new Ticket to
     * the Cart.
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

    /**
     * Locates the index of a Ticket for a given FilmID
     *
     * @param searchID
     * @return
     */
    public int findFilmID(int searchID) {
        for (int i = 0; i < TicketsInCart.size(); i++) {
            if (TicketsInCart.get(i).getFilmID() == searchID) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the specified number of tickets for the given filmID
     *
     * @param filmID
     * @param quantity
     * @return -1 for failure, 0 for complete removal, 1 for partial removal
     */
    public int removeTicket(int filmID, int[] quantity) {
        int index = -1;
        if (isEmpty()) {
            return index; //If the ArrayList is empty, we can just stop.
        }
        index = findFilmID(filmID); //Find the ticket
        if (index == -1) {
            return index; //Failure. No such ticket
        }
        int[] available = TicketsInCart.get(index).getQuantity();
        int output = 0;
        for (int i = 0; i < Ticket.TYPES_OF_TICKETS; i++) {
            if (quantity[i] > available[i]) {
                output = -2; //Failure. Not enough tickets.
            } else if (quantity[i] < available[i]) {
                quantity[i] = (-1 * quantity[i]);
                output = 1; //This tells us that there is at least one more left
            } else {
                quantity[i] = (-1 * quantity[i]);
            }
            if (output == 0) //This means there are no more left. Drop the Ticket
            {
                removeTicket(filmID);
            } else {
                TicketsInCart.get(index).updateQuantity(quantity);
            }
        }
        return output;
    }

    /**
     * Removes a Ticket object from the ArrayList
     *
     * @param filmID
     */
    public void removeTicket(int filmID) {
        int index = findFilmID(filmID);
        TicketsInCart.remove(index);
    }

    /**
     * Gets the number of tickets (NOT objects)
     *
     * @param index
     * @return The total number of tickets in the Ticket object
     */
    public int[] getQuantity(int index) {
        return TicketsInCart.get(index).getQuantity();
    }

    /**
     * Dumps all the Ticket objects in the Cart
     */
    public void clear() {
        TicketsInCart.removeAll(TicketsInCart);
    }

    /**
     * Gets the total price of the tickets in the Tickets BEFORE TAX
     *
     * @return
     */
    public double getSubtotal() {
        total = 0.0;
        for (int i = 0; i <= TicketsInCart.size(); i++) {
            total += TicketsInCart.get(i).getSubtotal();
        }
        return total;
    }

    /**
     * Adds tax to the subTotal
     *
     * @return
     */
    public double getTotal() {
        total += total * TAX_RATE;
        return total;
    }

    /**
     * Finds out if the Cart is empty
     *
     * @return
     */
    public Boolean isEmpty() {
        return TicketsInCart.isEmpty();
    }

    /**
     * Get the specified Ticket object
     *
     * @param index
     * @return
     */
    public Ticket get(int index) {
        return TicketsInCart.get(index);
    }

    /**
     * Get the number of Ticket objects in the Cart
     *
     * @return
     */
    public int size() {
        return TicketsInCart.size();
    }
}
