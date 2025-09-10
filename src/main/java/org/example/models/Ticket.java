package org.example.models;

public class Ticket {
    TicketLocation location;
    TicketType type = TicketType.GENERAL;
    float price;

    public Ticket() {
    }

    public void setLocation(TicketLocation location) {
        this.location = location;
    }

    public TicketLocation getLocation() {
        return location;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return 
                "Tipo de Entrada: " + location.toString().toLowerCase() + "\n" +
                "Precio Entrada: $"+ Float.toString(price);
                }    
}
