
package org.example.services;

import java.util.ArrayList;
import org.example.models.Cart;
import org.example.models.Ticket;

public class CartService {
    
    public static void addTicket(Cart cart, Ticket ticket){
        ArrayList<Ticket> cartArray = cart.getCart();
        cartArray.add(ticket);
        cart.setCart(cartArray);
    }
    public static void updateTotal(Cart cart, Ticket ticket){
        float cartTotal = cart.getTotal();
        float ticketPrice = ticket.getPrice();
        float originalTotal = cartTotal + ticketPrice;
        cart.setTotal(originalTotal);
        if (cart.getCart().size() >= 3){
            cart.setDiscountedTotal(originalTotal * 0.90f);
        } 
    }
}
