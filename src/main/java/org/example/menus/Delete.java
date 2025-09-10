package org.example.menus;

import org.example.models.Cart;
import org.example.models.Ticket;
import org.example.services.CartService;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete {
    /**
     * This class handles deletion of objects inside the cart
     * @param scanner Scanner Object to interact with the user
     * @param cart Cart Object with the current state of the purchase cart
     */
    public static void menu(Scanner scanner, Cart cart){
        ArrayList<Ticket> tickets = cart.getCart();
        System.out.println("Seleccione entrada a eliminar");
        for (int i = 0; i < tickets.size(); i++){
            Ticket ticket = tickets.get(i);
            System.out.print(i+1 +": "+ ticket.getLocation() + " |");
            System.out.print(ticket.getType().toString().replace("_", " ") + " |");
            System.out.print("$" + ticket.getPrice() + "\n");
        }
        while(true) {
            System.out.print("Opcion: ");
            String rawOption = scanner.nextLine();
            int option;
            try {
                option = Integer.parseInt(rawOption);
                // remove one to interact with index0
                option--;
                if (option >= cart.getCart().size() || option < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Indice no valido");
                continue;
            }
            // confirmacion
            while(true){
                System.out.println("Esta usted seguro de borrar el ticket: ");
                System.out.println(cart.getCart().get(option).toString());
                System.out.print("[Y|N] ");
                String confirmation = scanner.nextLine();
                switch (confirmation) {
                    case "y", "s":
                        CartService.removeTicket(cart, option);
                    case "n":
                        return;
                    default:
                        System.err.println("Opcion no valida");
                }
            }
        }
    }
}
