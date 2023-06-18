package N_17Hackerrank;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description:
 * <p>
 *     Los comparadores se utilizan para comparar dos objetos. En este desafío, creará un comparador y lo usará para ordenar una matriz.
 * </p>
 * <p>
 *     La clase Player se proporciona para usted en su editor. Tiene 2 campos: un <b>name <i>String</i></b> y un <b>score <i>Integer</i></b>.
 * </p>
 * <p>
 *     Dada una matriz de <b><i>n</i></b> Objetos del jugador , escriba un comparador que los clasifique en orden de puntuación decreciente; si <b>2</b> o más jugadores tienen la misma puntuación, ordene a esos jugadores alfabéticamente por nombre. Para hacer esto, debe crear una clase Checker que implemente la interfaz Comparator , luego escribir un método int compare(Player a, Player b) implementando el método Comparator.compare(T o1, T o2) .
 * </p>
 *
 * @FormatoDeEntrada:
 * <p>
 *     La entrada de stdin es manejada por el código auxiliar bloqueado en la clase Solution .
 * </p>
 * <p>
 *     La primera línea contiene un número entero,, que indica el número de jugadores.
 * </p>
 * <p>
 *     Cada una de las n las líneas subsiguientes contienen name y score, respectivamente.
 * </p>
 *
 * @Restricciones:
 * <ul>
 *     <li><b><i>0</i> <= <i>score</i> <= <i>1000</i></b></li>
 *     <li>los <b><i>2</i></b> jugadores pueden tener el mismo nombre</li>
 *     <li>Los nombres de los jugadores consisten en letras minúsculas en inglés.</li>
 * </ul>
 * @FormatoDeSalida:
 * <p>
 *     Usted no es responsable de imprimir ningún resultado en la salida estándar. El código auxiliar bloqueado en Solution creará un objeto Checker , lo usará para ordenar la matriz Player e imprimirá cada elemento ordenado.
 * </p>
 *
 * @Ejemplo:
 * <h3>Entrada</h3>
 * <ol>
 *     <li>5</li>
 *      <li>amy 100</li>
 *      <li>david 100</li>
 *      <li>heraldo 50</li>
 *      <li>aakansha 75</li>
 *      <li>aleksa 150</li>
 * </ol>
 * <h3>Salida</h3>
 * <ol>
 *      <li>aleksa 150</li>
 *      <li>amy 100</li>
 *      <li>david 100</li>
 *      <li>aakansha 75</li>
 *      <li>heraldo 50</li>
 * </ol>
 */
public class JavaComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].getName(), player[i].getScore());
        }
    }
}

class Checker implements Comparator<Player>{
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getScore() == o2.getScore()){
            return o1.getName().compareTo(o2.getName());
        }else {
            return o2.getScore() - o1.getScore();
        }
    }
}

class Player{
    private String name;
    private Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
