package org.example.models;

public class Ticket {
    TicketType type;
    float price;

    public Ticket() {
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketType getType() {
        return type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
