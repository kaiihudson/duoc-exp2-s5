package org.example.menus;

import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.services.Pricing;

import java.util.Scanner;

public class Purchase {
    public static void menu(Scanner sc) {

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
                    ticket.setType(TicketType.VIP);
                    validType = true;
                    break;
                case "platea":
                    ticket.setType(TicketType.PLATEA);
                    validType = true;
                    break;
                case "general":
                    ticket.setType(TicketType.GENERAL);
                    validType = true;
                    break;
                case "galeria":
                    ticket.setType(TicketType.GALERIA);
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
        Pricing.setDiscount(isStudent, isElderly, ticket);
    }

    private static boolean askInfo(String type, Scanner scanner){
        do {
            System.out.println("Es usted " + type + " ? [Y/N]");
            String answer = scanner.nextLine();
            switch (answer) {
                 case "Y", "S":
                     return true;
                 case "N":
                     return false;
                 default:
                     System.err.println("Opcion no valida");
            }
        } while(true);
    }
}
