package Movie;

import java.util.ArrayList;

/**
 *
 * @author Hiromi Cota
 */
public class Cart {

    ArrayList<Ticket> TicketsInCart;    
    double total;
    final double TAX_RATE = 0.089;

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
        int index = findFilmID(filmID);
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
                TicketsInCart.remove(index);     
            else
            {
                TicketsInCart.get(index).updateQuantity(quantity);
            }
        }
        return output;
    }

    public int[] getQuantity(int index) {
        return TicketsInCart.get(index).getQuantity();
    }

    public void removeTicket(int filmID) {
        int index = findFilmID(filmID);
        TicketsInCart.remove(index);        
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
