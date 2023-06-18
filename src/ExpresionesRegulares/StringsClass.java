package ExpresionesRegulares;

import java.util.Scanner;

public class StringsClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingggresa el primer dato: ");
        String dato1 = scanner.nextLine();

        System.out.print("Ingresa el segundo dato: ");
        String dato2 = scanner.nextLine();

        // Hacer algo con los datos ingresados
        System.out.println("Primer dato: " + dato1);
        System.out.println("Segundo dato: " + dato2);

        // Cerrar el scanner
        scanner.close();
    }
}
