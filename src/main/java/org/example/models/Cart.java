package org.example.models;

import java.util.ArrayList;

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
    
}
