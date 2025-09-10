package org.example.menus;

import org.example.models.Ticket;
import org.example.models.TicketLocation;
import org.example.services.Pricing;

import java.util.Scanner;
import org.example.models.Cart;
import org.example.services.CartService;

public class Purchase {
    public static void menu(Scanner sc, Cart cart) {

        Ticket ticket = new Ticket();

        boolean validType = false;
        // User Purchase Journey
        System.out.println("Bienvenido al modulo de compras");
        System.out.println("Tipos de entrada disponible: VIP | PLATEA | GENERAL | GALERIA");

        do {
            System.out.print("Seleccione su tipo de entrada:");
            String opcion = sc.nextLine().toLowerCase();

            switch (opcion){
                case "vip":
                    ticket.setLocation(TicketLocation.VIP);
                    validType = true;
                    break;
                case "platea":
                    ticket.setLocation(TicketLocation.PLATEA);
                    validType = true;
                    break;
                case "general":
                    ticket.setLocation(TicketLocation.GENERAL);
                    validType = true;
                    break;
                case "galeria":
                    ticket.setLocation(TicketLocation.GALERIA);
                    validType = true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }

        } while (!validType);
        Pricing.addPrice(ticket);
        boolean isStudent = askInfo("Estudiante", sc);
        boolean isElderly = false;
        if (!isStudent){
            isElderly = askInfo("Tercera Edad", sc);
        }
        // set discount based on price
        Pricing.setDiscount(isStudent, isElderly, ticket);
        System.out.println(ticket.toString());
        // add ticket to cart
        CartService.addTicket(cart, ticket);
        // update total in cart
        CartService.updateTotal(cart, ticket);
    }

    private static boolean askInfo(String type, Scanner scanner){
        do {
            System.out.println("Es usted " + type + " ? [Y/N]");
            String answer = scanner.nextLine().toLowerCase();
            switch (answer) {
                 case "y", "s":
                     return true;
                 case "n":
                     return false;
                 default:
                     System.err.println("Opcion no valida");
            }
        } while(true);
    }
}
