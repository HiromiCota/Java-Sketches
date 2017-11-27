package Movie;

import java.util.ArrayList;

/**
 *
 * @author Hiromi Cota
 */
public class Cart {

    ArrayList<Ticket> TicketsInCart;
    ArrayList Quantity;
    double total;
    final double TAX_RATE = 0.089;

    public void addShowTime(Ticket ticket, int quantity) {
        int index = TicketsInCart.indexOf(ticket);
        if (index != -1) {
            quantity = (int) Quantity.get(index);
            quantity++;
            Quantity.remove(index);
            Quantity.add(index, quantity);
        } else {
            TicketsInCart.add(ticket);
            Quantity.add(1);
        }
    }

    public void addShowTime(Ticket ticket) {
        addShowTime(ticket, 1);
    }

    public int removeTicket(Ticket ticket, int quantity) {
        int index = TicketsInCart.indexOf(ticket);
        if (index == -1) {
            return index; //Failure. No such ticket
        }
        quantity -= (int) Quantity.get(index);
        if (quantity > 0) {
            Quantity.remove(index);
            Quantity.add(index, quantity);
            return 0; //Success, no issues.
        } else {
            TicketsInCart.remove(index);
            Quantity.remove(index);
            return 1; //Success, no more of that quantity exist.
        }
    }

    public int getQuantity(int index) {
        return (int) Quantity.get(index);
    }

    public int removeTicket(Ticket ticket) {
        return removeTicket(ticket, 1);
    }

    public void clear() {
        Quantity.removeAll(Quantity);
        TicketsInCart.removeAll(TicketsInCart);
    }

    public double getSubtotal() {
        total = 0.0;
        for (int i = 0; i <= TicketsInCart.size(); i++) {
            total += TicketsInCart.get(i).getPrice() * (double) Quantity.get(i);
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
