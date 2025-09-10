
package org.example.services;

import java.util.ArrayList;
import org.example.models.Cart;
import org.example.models.Ticket;

public class CartService {
    /**
     * Function to add ONE ticket to the cart
     * @param cart   Cart Object with the current state of the purchase cart
     * @param ticket Ticket Object to be introduced into the cart
     */
    public static void addTicket(Cart cart, Ticket ticket){
        ArrayList<Ticket> cartArray = cart.getCart();
        cartArray.add(ticket);
        cart.setCart(cartArray);
    }

    /**
     * Function to calculate the new total for the cart on a new ticket
     * @param cart Cart Object with the current state of the purchase cart
     * @param ticket Ticket Object that has been introduced to the cart
     */
    public static void calculateTotalNewTicket(Cart cart, Ticket ticket){
        cart.setTotal(cart.getTotal() + ticket.getPrice());
        updateTotal(cart);
    }

    /**
     * Helper Function to update the total of the cart for Special purposes.
     * @param cart Cart Object with the current state of the purchase cart
     */
    public static void updateTotal(Cart cart){
        if (cart.getCart().size() >= 3){
            cart.setDiscountedTotal(cart.getTotal() * 0.9f);
        } else {
            cart.setDiscountedTotal(0);
        }
    }

    /**
     * Function to PERMANENTLY remove a ticket from the cart
     * THIS PROCESS IS DESTRUCTIVE AND DOES NOT ALLOW REGENERATION
     * @param cart Cart Object with the current state of the purchase cart
     * @param index index reference that points to a certain Ticket inside the cart.
     */
    public static void removeTicket(Cart cart, int index){
        Ticket ticket = cart.getCart().get(index);
        cart.getCart().remove(index);
        cart.setTotal(cart.getTotal() - ticket.getPrice());
        updateTotal(cart);
    }
}
