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

    /**
     * Function that adds the price to a Ticket Object
     * @param ticket Ticket Object with a Location set
     */
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

    /**
     * Function to update the price based on if the person is a student or an elderly person
     * @param student boolean data indicating if student
     * @param elderly boolean data indicating if elderly person
     * @param ticket Ticket Object with Location and Price
     */
    public static void setDiscount(boolean student, boolean elderly, Ticket ticket){
        double currentPrice = ticket.getPrice();
        if (student) {
            ticket.setAppliedDiscount(0.1);
            ticket.setPrice(currentPrice * 0.9);
            ticket.setType(TicketType.ESTUDIANTE);
        } else {
            if (elderly) {
                ticket.setAppliedDiscount(0.15);
                ticket.setPrice(currentPrice * 0.85);
                ticket.setType(TicketType.TERCERA_EDAD);
            }
        }
    }
}
