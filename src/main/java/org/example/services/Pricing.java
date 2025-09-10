package org.example.services;

import org.example.models.Ticket;
import org.example.models.TicketLocation;
import org.example.models.TicketType;

public class Pricing {
    // create static pricing
    static float vipPrice = 50000;
    static float plateaPrice = 40000;
    static float generalPrice = 30000;
    static float galeriaPrice = 20000;

    public static void addPrice(Ticket ticket){
        TicketLocation type = ticket.getLocation();
        switch (type){
            case VIP:
                ticket.setPrice(vipPrice);
                return;
            case PLATEA:
                ticket.setPrice(plateaPrice);
                return;
            case GALERIA:
                ticket.setPrice(galeriaPrice);
                return;
            case GENERAL:
                ticket.setPrice(generalPrice);
                return;
            // in case of out-of-enum case we return as-is
            default:
        }
    }
    public static void setDiscount(boolean student, boolean elderly, Ticket ticket){
        float currentPrice = ticket.getPrice();
        if (student) {
            ticket.setPrice(currentPrice * 0.9f);
            ticket.setType(TicketType.ESTUDIANTE);
        } else {
            if (elderly) {
                ticket.setPrice(currentPrice * 0.85f);
                ticket.setType(TicketType.TERCERA_EDAD);
            }
        }
    }
}
