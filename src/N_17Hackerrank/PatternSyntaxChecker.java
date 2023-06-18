package N_17Hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @DEscription:
 * <p>
 *     Usando <b><i>Regex</i></b> , podemos hacer coincidir o buscar fácilmente patrones en un texto. Antes de buscar un patrón, debemos especificar uno utilizando una sintaxis bien definida.
 * </p>
 * <p>
 *     En este problema, se te da un patrón. Debe verificar si la sintaxis del patrón dado es válida.
 * </p>
 * @Nota:
 * <p>
 *     Nota : en este problema, una expresión regular solo es válida si puede compilarla utilizando el método <a href="http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#compile%28java.lang.String%29">Pattern.compile</a> .
 * </p>
 * @FormatoDeEntrada:
 * <p>
 *     La primera línea de entrada contiene un número entero N, que denota el número de casos de prueba. El siguiente N Las líneas contienen una cadena de caracteres imprimibles que representan el patrón de una expresión regular.
 * </p>
 * @FormatoDeSalida:
 * <p>
 *     Para cada caso de prueba, imprima Validsi la sintaxis del patrón dado es correcta. De lo contrario, imprima Invalid. No imprima las comillas.
 * </p>
 *
 * @Ejemplo:
 * <h3>Entrdad</h3>
 * <ul>
 *     <li>3</li>
 *     <li>([A-Z])(.+)</li>
 *     <li>[AZ[a-z](a-z)</li>
 *     <li>batcatpat(nat</li>
 * </ul>
 * <h3>Salida</h3>
 * <ul>
 *     <li>Valid</li>
 *     <li>Invalid</li>
 *     <li>Invalid</li>
 * </ul>
 */
public class PatternSyntaxChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            Pattern pattern = Pattern.compile(s);
            boolean isValid = pattern.matcher(s).matches();

            if (isValid){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }

        }
    }
}
