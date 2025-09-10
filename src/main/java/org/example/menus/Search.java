package org.example.menus;

import java.util.ArrayList;
import java.util.Scanner;
import org.example.models.Cart;
import org.example.models.Ticket;
import org.example.models.TicketLocation;
import org.example.models.TicketType;

public class Search {
    public static void menu(Scanner sc, Cart cart){
        ArrayList<Ticket> cartArray = cart.getCart();
        boolean done = false;
        Ticket ticket = null;
        ArrayList<Ticket> tickets = null;
        do {
            System.out.println("Indique Criterio de busqueda");
            System.out.println("1. Numero");
            System.out.println("2. Ubicacion");
            System.out.println("3. Tipo");
            System.out.print("Criterio de Busqueda: ");
            String option = sc.nextLine();
            int realOption = 0;
            try {
                realOption = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                System.err.println("Opcion no valida");
            }
            switch (realOption) {
                case 1:
                    // search by number in array
                    ticket = searchById(sc, cart);
                    done = true;
                    break;
                case 2:
                    // search by ubicacion (VIP/PLATEA/ETC)
                    tickets = searchByLocation(sc, cart);
                    done = true;
                    break;
                case 3:
                    // search by type (ESTUDIANTE/TERCERA_EDAD/GRAL)
                    tickets = searchByType(sc, cart);
                    done =true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        } while (!done);
        if (ticket != null) {
            System.out.println(ticket.toString());
        }
        if (tickets != null) {
            System.out.println(tickets.toString());
        }
    }

    private static Ticket searchById(Scanner sc, Cart cart){
        int i = -1;

        while(true) {
            System.out.print("Ingrese numero de entrada: [1-" + cart.getCart().size() + "] ");
            String index = sc.nextLine();
            try {
                i = Integer.parseInt(index);
                // add one to make it Index 1
                i--;
                if (i >= cart.getCart().size() || i < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Indice no Valido");
                continue;
            }
            if (i != -1) {
                return cart.getCart().get(i);
            }
        }
    }
    private static ArrayList<Ticket> searchByLocation(Scanner sc, Cart cart){
        ArrayList<Ticket> cartArray = cart.getCart();
        ArrayList<Ticket> partial = new ArrayList<>();
        boolean done = false;
        TicketLocation location = null;
        while(!done){
            System.out.println("Ingrese la ubicacion");
            System.out.print("[VIP|PLATEA|GENERAL|GALERIA]");
            String rawLocation = sc.nextLine().toLowerCase();
            switch (rawLocation) {
                case "vip":
                    location = TicketLocation.VIP;
                    done = true;
                    break;
                case "platea":
                    location = TicketLocation.PLATEA;
                    done = true;
                    break;
                case "general":
                    location = TicketLocation.GENERAL;
                    done = true;
                    break;
                case "galeria":
                    location = TicketLocation.GALERIA;
                    done = true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        }
        for (Ticket ticket: cartArray){
            if(location == ticket.getLocation()){
                partial.add(ticket);
            }
        }
        return partial;
    }
    private static ArrayList<Ticket> searchByType(Scanner sc, Cart cart){
        ArrayList<Ticket> cartArray = cart.getCart();
        ArrayList<Ticket> partial = new ArrayList<>();
        boolean done = false;
        TicketType type = null;
        while(!done){
            System.out.println("Ingrese el tipo de tarifa");
            System.out.print("[ESTUDIANTE|TERCERAEDAD|GENERAL]");
            String rawType = sc.nextLine().toLowerCase();
            switch (rawType) {
                case "estudiante":
                    type = TicketType.ESTUDIANTE;
                    done = true;
                    break;
                case "platea":
                    type = TicketType.TERCERA_EDAD;
                    done = true;
                    break;
                case "general":
                    type = TicketType.GENERAL;
                    done = true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        }
        for (Ticket ticket: cartArray){
            if(type == ticket.getType()){
                partial.add(ticket);
            }
        }
        return partial;
    }
}
