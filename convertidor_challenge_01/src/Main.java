
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       boolean continuar = true;
       Convertor conv = new Convertor();

       while(continuar){
           System.out.println("----------------------------------------------------");
           System.out.println("         BIENVENIDO AL CONVERTIDOR DE MONEDAS RBCG");
           System.out.println("----------------------------------------------------");
           System.out.println("Selecciona una opción:");
           System.out.println("1. Convertir monedas");
           System.out.println("2. Salir");
           System.out.println("----------------------------------------------------");
           System.out.print("Opción: ");
           int opcion = scanner.nextInt();

           switch (opcion){
               case 1:
                   conversor(scanner, conv);
                   break;

               case 2:
                     continuar = false;
                     break;
               default:
                     System.out.println("Opción no válida");
           }
       }
    }

    private static void conversor(Scanner scanner, Convertor conv) {
        String[] monedas = {
                "PEN (Sol Peruano)",
                "USD (Dólar estadounidense)",
                "EUR (Euro)",
                "GBP (Libra esterlina)",
                "JPY (Yen japonés)",
                "CHF (Franco suizo)",
                "AUD (Dólar australiano)",
                "CAD (Dólar canadiense)",
                "CNY (Yuan chino)",
                "HKD (Dólar de Hong Kong)",
                "NZD (Dólar neozelandés)",
                "RUB (Rublo ruso)",
                "INR (Rupia india)",
                "BRL (Real brasileño)",
                "MXN (Peso mexicano)"
        };

        System.out.println("Monedas disponibles:");
        for (String moneda : monedas) {
            System.out.println(" - " + moneda);
        }

        System.out.print("Ingresa la moneda desde la que partes (ej. USD): ");
        String base = scanner.next().toUpperCase();
        System.out.print("Ingresa la moneda a la que quieras convertir (ej. EUR): ");
        String objetivo = scanner.next().toUpperCase();
        System.out.print("Ingresa la cantidad de " + base + " que quieres convertir a " + objetivo + ": ");
        double cantidad = scanner.nextDouble();
        System.out.println("Convirtiendo " + cantidad + " " + base + " a " + objetivo + "...");
        double resultado = conv.convertirMonedas(base, objetivo, cantidad);
        System.out.println(cantidad + " " + base + " es igual a " + resultado + " " + objetivo);
        System.out.println("\n");
    }

}

