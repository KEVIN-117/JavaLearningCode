
package N_17Hackerrank;
import java.util.Scanner;

/**
 *@Description: <p>
 *     La función System.out.printf de Java se puede utilizar para imprimir la salida formateada.
 *  *     El propósito de este ejercicio es probar su comprensión del formato de salida usando printf.
 *  *     Para empezar, se le proporciona una parte de la solución en el editor;
 *  *     debe formatear e imprimir la entrada para completar la solución.
 *  *     Formato de entrada
 *  *     Cada línea de entrada contendrá una cadena seguida de un número entero.
 *  *     Cada String tendrá un máximo decaracteres alfabéticos, y cada número
 *  *     entero estará en el rango inclusivo dea.
 *</p>
 *
 * @FormatoDeSalida: <p>
 *     En cada línea de salida debe haber dos columnas:
 *           La primera columna contiene la Cadena y se justifica a la izquierda usando exactamentecaracteres.
 *           La segunda columna contiene el número entero , expresado en exactamentedígitos; si la entrada
 *           original tiene menos de tres dígitos, debe rellenar los primeros dígitos de su salida con ceros.
 * </p>
 *
 * @EntradaDeMuestra: <p>
 *     <ul>
 *         <li>java 100</li>
 *         <li>cpp 65</li>
 *         <li>python 50</li>
 *     </ul>
 * </p>
 * @SalidaDeMuestra: <div>
 *      <p>================================</p>
 *      <pre>java           100</pre>
 *      <pre>cpp            065</pre>
 *      <pre>python         050</pre>
 *      <p>================================</p>
 * </div>
 */
public class JavaOutputFormatting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            Programing programing = new Programing(sc.next(), sc.nextInt());
            //Complete this line
            System.out.printf("%-"+((programing.getName().length()+15-programing.getName().length())-1)+"s %03d\n", programing.getName(), programing.getAmount());
        }
        System.out.println("================================");
    }
}

class Programing{
    private String name;
    private int amount;

    public Programing(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
