package N_17Hackerrank;

import java.util.Scanner;

/**
 * <p>
 *     Los bloques de inicialización estática se ejecutan cuando se carga la clase y puede inicializar variables estáticas en esos bloques.
 * Es hora de poner a prueba tus conocimientos sobre los bloques de inicialización estáticos . Puedes leer sobre esto
 * <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html">aqui</a>
 * </p>
 * <p>
 *     Se le da una solución de clase con un método principal . Complete el código dado para que genere el área de un paralelogramo con ancho <i>B</i> y <i>H</i> altura. Debe leer las variables de la entrada estándar.
 * </p>
 *
 * @condicion: <p> Si <b><i> B <= 0  </i></b> o <b><i> H <= 0  </i></b>, el resultado debe ser "java.lang.Exception: el ancho y la altura deben ser positivos" sin comillas. </p>
 * @FormatoDeEntrada: <p>Hay dos líneas de entrada. La primera línea contiene B: la anchura del paralelogramo. La siguiente línea contiene h: la altura del paralelogramo.</p>
 *
 * @Restricciones: <p> <b><i> -100 <= B <= 100  </i></b> </p> <p><b><i> -100 <= H <= 100  </i></b> </p>
 *
 * @FormatoDeSalida: <p>Si ambos valores son mayores que cero, entonces el método principal debe generar el área del paralelogramo . De lo contrario, imprima "java.lang.Exception: el ancho y la altura deben ser positivos" sin comillas.</p>
 *
 * @EjemploDeEntrada: <ol>
 *     <li>
 *         <h3>Ejemplo de entrada</h3>
 *         <ul>
 *             <li>1</li>
 *             <li>3</li>
 *         </ul>
 *         <h3>Ejemplo de Salida</h3>
 *         <ul>
 *            <li>3</li>
 *         </ul>
 *     </li>
 *
 *     <li>
 *         <h3>Ejemplo de entrada</h3>
 *         <ul>
 *             <li>-1</li>
 *             <li>2</li>
 *         </ul>
 *         <h3>Ejemplo de Salida</h3>
 *         <ul>
 *            <li>java.lang.Exception: Breadth and height must be positive</li>
 *         </ul>
 *     </li>
 * </ol>
 */

public class JavaStaticInitializerBlock {
    static Scanner scanner = new Scanner(System.in);
    static Boolean flag = true;
    static int B = scanner.nextInt();
    static int H = scanner.nextInt();

    public static void calculateArea(){
        if (B <= 0 || H <= 0){
            flag = false;
        }
    }
    static {
        calculateArea();
        if (!flag){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
    public static void main(String[] args){

        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main
}
