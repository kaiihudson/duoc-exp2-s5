package org.example.menus;

import java.util.ArrayList;
import java.util.Scanner;
import org.example.models.Cart;
import org.example.models.Ticket;
import org.example.models.TicketLocation;
import org.example.models.TicketType;

public class Search {
    /**
     * This class handles searches inside the cart Object
     * @param sc Scanner Object to interact with the user
     * @param cart Cart Object with the current state of the purchase cart
     */
    public static void menu(Scanner sc, Cart cart){
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
            System.out.println("-".repeat(30));
            System.out.println(ticket);
            System.out.println("-".repeat(30));
        }
        if (tickets != null) {
            for(Ticket ticket1: tickets){
                System.out.println("-".repeat(30));
                System.out.println(ticket1.toString());
                System.out.println("-".repeat(30));
            }

        }
    }

    /**
     * Function to search for a certain id inside the cart.
     * @param sc Scanner Object to interact with the user.
     * @param cart Cart Object with the current state of the purchase cart.
     * @return Ticket Object that matches the id.
     */
    private static Ticket searchById(Scanner sc, Cart cart){
        int i;
        while(true) {
            System.out.print("Ingrese numero de entrada: [1-" + cart.getCart().size() + "] ");
            String index = sc.nextLine();
            try {
                i = Integer.parseInt(index);
                // remove one to interact with index0
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

    /**
     * Function to iterate over the cart in search a certain Location
     * @param sc Scanner Object to interact with the user
     * @param cart Cart Object with the current state of the purchase cart
     * @return ArrayList containing the search hits for the query
     */
    private static ArrayList<Ticket> searchByLocation(Scanner sc, Cart cart){
        ArrayList<Ticket> cartArray = cart.getCart();
        ArrayList<Ticket> partial = new ArrayList<>();
        boolean done = false;
        TicketLocation location = null;
        while(!done){
            System.out.println("Ingrese la ubicacion");
            System.out.print("[VIP|PLATEA|GENERAL|GALERIA] ");
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
    /**
     * Function to iterate over the cart in search a certain Type
     * @param sc Scanner Object to interact with the user
     * @param cart Cart Object with the current state of the purchase cart
     * @return ArrayList containing the search hits for the query
     */
    private static ArrayList<Ticket> searchByType(Scanner sc, Cart cart){
        ArrayList<Ticket> cartArray = cart.getCart();
        ArrayList<Ticket> partial = new ArrayList<>();
        boolean done = false;
        TicketType type = null;
        while(!done){
            System.out.println("Ingrese el tipo de tarifa");
            System.out.print("[ESTUDIANTE|TERCERAEDAD|GENERAL] ");
            String rawType = sc.nextLine().toLowerCase();
            switch (rawType) {
                case "estudiante":
                    type = TicketType.ESTUDIANTE;
                    done = true;
                    break;
                case "tercera edad", "terceraedad":
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
