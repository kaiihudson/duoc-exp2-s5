package org.example.menus;

import org.example.models.Cart;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static void execute(){
        // Initialize variables for the current scope
        Cart cart = new Cart();
        boolean done = false;

        // Generate a menu for repetitive use
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. Venta de Entradas");
        menuOptions.add("2. Promociones Activas");
        menuOptions.add("3. Busqueda de Entradas");
        menuOptions.add("4. Eliminacion de Entradas");
        menuOptions.add("5. Salir");

        // Initalize Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Teatro Moro");
        do {
            // Print the menu in order
            for (String menuOption : menuOptions) {
                System.out.println(menuOption);
            }
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
                    Specials.menu();
                    break;
                case 3:
                    Search.menu(sc, cart);
                    break;
                case 4:
//                    delete();
                    break;
                case 5:
                    done = true;
                    break;
                default:
                    System.err.println("Opcion no valida");
            }
          }

        } while (!done);

        sc.close();
    }
}
