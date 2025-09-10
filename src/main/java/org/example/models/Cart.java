package org.example.models;

import java.util.ArrayList;

/**
 * Cart Model
 */
public class Cart {
    ArrayList<Ticket> cart = new ArrayList<>();
    float total = 0;
    float discountedTotal = 0;

    public Cart() {}

    public ArrayList<Ticket> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Ticket> cart) {
        this.cart = cart;
    }
    

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDiscountedTotal(float discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < cart.size(); i++){
            Ticket ticket = cart.get(i);
            data.append(i + 1).append(": ").append(ticket.getLocation()).append(" |");
            data.append(ticket.getType().toString().replace("_", " ")).append(" |");
            data.append("$").append(ticket.getPrice()).append("\n");
        }
        return "Total del carro: $"+ (discountedTotal > 0? discountedTotal : total ) +"\n"+ data;
    }
}
