package vista;

import java.util.Scanner;

public class Escaner {

    private static Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Debes ingresar un número.");
            scanner.next(); // limpiar entrada inválida
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return valor;
    }
}
