package org.example.models;

/**
 * Ticket Model
 */
public class Ticket {
    TicketLocation location;
    TicketType type = TicketType.GENERAL;
    double appliedDiscount = 0;
    double price;

    public Ticket() {
    }

    public void setLocation(TicketLocation location) {
        this.location = location;
    }

    public TicketLocation getLocation() {
        return location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setAppliedDiscount(double appliedDiscount) {
        this.appliedDiscount = appliedDiscount;
    }

    @Override
    public String toString() {
        String NOMBRE_TEATRO = "Teatro Moro";
        String header = "=".repeat(40) + "\n"+
                " ".repeat((40 - NOMBRE_TEATRO.length())/2) + NOMBRE_TEATRO
                + " ".repeat((40 - NOMBRE_TEATRO.length())/2) + "\n" +
                "=".repeat(40) + "\n";
        String discount = "";
        if (appliedDiscount != 0) {
            discount = "\nDescuento aplicado: " + appliedDiscount*100 + "%";
        }
        return
                header +
                "Locacion de Entrada: " + location.toString().toLowerCase()
                        + "\n" + "Tipo de Entrada: " + type.toString().replace("_", " ").toLowerCase()
                        +  discount
                        + "\n" + "Precio Entrada: $"+ price
                        + "\n" + "=".repeat(40)
                        + "\nGracias por comprar en " + NOMBRE_TEATRO
                        + "\n" + "=".repeat(40);
                }    
}
