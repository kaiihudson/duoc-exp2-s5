package org.example.menus;

import org.example.models.Cart;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    /**
     * Main class
     * This program is meant for ticket purchase, search and deletion for TEATRO MORO
     * @author Sebastian Rodriguez Ravetllat
     */
    public static void execute(){
        // Initialize variables for the current scope
        Cart cart = new Cart();
        boolean done = false;

        // Generate a menu for repetitive use
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("Menu Principal");
        menuOptions.add("1. Venta de Entradas");
        menuOptions.add("2. Promociones Activas [DISABLED]");
        menuOptions.add("3. Busqueda de Entradas [DISABLED]");
        menuOptions.add("4. Eliminacion de Entradas [DISABLED]");
        menuOptions.add("5. Salir");

        // Initalize Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Teatro Moro");
        do {
            if(!cart.getCart().isEmpty()) {
                System.out.println("Tu carro contiene: " + cart.getCart().size() + " entrada(s)");
                System.out.println(cart);
            }
            // Print the menu in order
            for (String menuOption : menuOptions) {
                System.out.println(menuOption);
            }
          System.out.print("Opcion: ");
          String option = sc.nextLine();
          int realOption = 0;
          try {
              realOption = Integer.parseInt(option);
          } catch (NumberFormatException e) {
              System.err.println("Opcion no valida");
          }
          if (realOption != 0) {
            switch (realOption) {
                case 1:
                    Purchase.menu(sc, cart);
                    break;
                case 2:
//                    Specials.menu();
                    System.out.println("OPCION DESHABILITADA");
                    break;
                case 3:
//                    Search.menu(sc, cart);
                    System.out.println("OPCION DESHABILITADA");
                    break;
                case 4:
//                    Delete.menu(sc, cart);
                    System.out.println("OPCION DESHABILITADA");
                    break;
                case 5:
                    done = true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
          }

        } while (!done);
        System.out.println("Gracias por preferir Teatro Moro");
        sc.close();
    }
}
