package N_17Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * <p>
 *     Dada una cadena s, haciendo coincidir la expresión regular [A-Za-z !,?._'@]+, divida la cadena en tokens . Definimos un token como una o más letras del alfabeto inglés consecutivas. Luego, imprime el número de fichas, seguido de cada ficha en una nueva línea.
 * </p>
 * @Nota: Puede encontrar útil el método String.split para completar este desafío.
 * @FormatoDeEntrada:
 * <p>
 *     Una sola cadena <b>s</b>
 * </p>
 * @Restriccioones:
 * <ul>
 *     <li><b><i>1</i></b> <= <b><i>length of s</i></b> <= <b><i>4*10<sup>15</sup></i></b></li>
 *     <li><b><i>s</i></b> se compone de cualquiera de los siguientes: letras del alfabeto inglés, espacios en blanco, signos de exclamación ( !), comas ( ,), signos de interrogación ( ?), puntos ( .), guiones bajos ( _), apóstrofes ( ') y símbolos de arroba ( @).</li>
 * </ul>
 *
 * @FormatoDeSalida:
 * <p>
 *     En la primera línea, imprime un número entero n, que indica el número de tokens en la cadena s ( no es necesario que sean únicos). A continuación, imprima cada uno de los n tokens en una nueva línea en el mismo orden en que aparecen en la cadena de entrada s.
 * </p>
 * @Ejemplo:
 * <h3>Entrada</h3>
 * <ul>
 *     <li>Hola, gracias por intentar este problema! ¡Espero que te ayude a aprender Java! ¡Buena suerte y que tenga un buen dia!</li>
 * </ul>
 * <h3>Salida</h3>
 * <ul>
 *      <li>21</li>
 *      <li>Hello</li>
 *      <li>thanks</li>
 *      <li>for</li>
 *      <li>attempting</li>
 *      <li>this</li>
 *      <li>problem</li>
 *      <li>Hope</li>
 *      <li>it</li>
 *      <li>will</li>
 *      <li>help</li>
 *      <li>you</li>
 *      <li>to</li>
 *      <li>learn</li>
 *      <li>java</li>
 *      <li>Good</li>
 *      <li>luck</li>
 *      <li>and</li>
 *      <li>have</li>
 *      <li>a</li>
 *      <li>nice</li>
 *      <li>day</li>
 * </ul>
 */
public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+|\\p{Punct}");
        System.out.println(Arrays.stream(words).filter(item -> !item.equals("")).count());
        for (String i: words) {
            if (!i.equals("")){
                System.out.println(i);
            }
        }

    }
}
