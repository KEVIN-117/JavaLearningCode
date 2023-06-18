package N_17Hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * <p>
 *     En informática, un conjunto es un tipo de datos abstracto que puede almacenar ciertos valores, sin ningún orden en particular y sin valores repetidos <b><i>{1, 2, 3}</i></b>, es un ejemplo de un conjunto, pero <b><i>{1, 2, 2}</i></b> no es un conjunto. Hoy aprenderá a usar conjuntos en Java resolviendo este problema.
 * </p>
 * <p>
 *     te da n pares de cuerdas. Dos pares (a, b) y (c, d)son identicos si a == c y b == d. Eso también implica (a, b) no es lo mismo que (b, a). Después de tomar cada par como entrada, debe imprimir el número de pares únicos que tiene actualmente.
 * Complete el código en el editor para resolver este problema.
 * </p>
 * @FormatoDeEntrada:
 * <p>
 *     En la primera línea, habrá un número T entero.que indica el número de pares. cada uno de los siguientes T Las líneas contendrán dos cadenas separadas por un solo espacio.
 * </p>
 *
 * @Restriciones:
 * <p>
 *     <ul>
 *         <li><b><i>1 <= T <= 100000</i></b></li>
 *         <li><b><i>La longitud de cada cadena es como máximo 5 y constará únicamente de letras minúsculas.</i></b></li>
 *     </ul>
 * </p>
 * @FormatoDeSalida:
 * <p>
 *     Imprimir T líneas. En el i<sub>th</sub>línea, imprime el número de pares únicos que tienes después de tomar i<sup>th</sup> pares como entrada.
 * </p>
 *
 * @Ejemplo:
 * <h3>Entrada</h3>
 * <ol>
 *     <li>john tom</li>
 *     <li>john mary</li>
 *     <li>john tom</li>
 *     <li>mary anna</li>
 *     <li>mary anna</li>
 * </ol>
*  <h3>Salida</h3>
 *  <ol>
 *      <li>1</li>
 *      <li>2</li>
 *      <li>2</li>
 *      <li>3</li>
 *      <li>3</li>
 *  </ol>
 */
public class JavaHashset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //scanner.next();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Persons person = new Persons(scanner.next(), scanner.next());
            set.add(person.getName() + " " + person.getSecondName());
            System.out.println(set.size());
        }
        //System.out.println(set);
        scanner.close();
    }
}

class Persons{
    private String name;
    private String secondName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Persons(String a, String b){
        this.name = a;
        this.secondName = b;
    }
}
