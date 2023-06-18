package N_17Hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * <div>
 *     <p>
 *         Una cadena que contiene solo paréntesis está equilibrada si se cumple lo siguiente: 1. si es una cadena vacía 2. si A y B son correctos, AB es correcto, 3. si A es correcto, (A) y {A} y [ A] también son correctas.
 *     </p>
 *     <p>
 *         Ejemplos de algunas cadenas balanceadas correctamente son: <b>"{}()", "[{()}]", "({()})"</b> Ejemplos de algunas cadenas desequilibradas son: "{}(", "({)}", "[[", "}{" etc. Dada una cadena, determine si está balanceada o no.
 *     </p>
 * </div>
 * @Formato_de_Entrada:
 * <p>Habrá varias líneas en el archivo de entrada, cada una con una sola cadena no vacía. Debe leer la entrada hasta el final del archivo. La parte del código que maneja la operación de entrada ya se proporciona en el editor.</p>
 * @Formato_de_salida:
 * <p>
 *     Para cada caso, imprima 'verdadero' si la cadena está balanceada, 'falso' de lo contrario.
 * </p>
 *
 * @Ejemplos
 * <div>
 *     <h3>Ejemplo de entrada</h3>
 *     <ol>
 *         <li>(({()})))</li>
 *         <li>({(){}()})()({(){}()})(){()}</li>
 *         <li>{}()))(()()({}}{}</li>
 *         <li>[]{}(){()}((())){{{}}}{()()}{{}{}}</li>
 *     </ol>
 *     <h3>Ejemplo de salida</h3>
 *     <ol>
 *         <li>false</li>
 *         <li>true</li>
 *         <li>false</li>
 *         <li>true</li>
 *     </ol>
 * </div>
 */
public class JavaStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(isValidString(s));
        }

    }

    /**
     *
     * @param s
     * @return Para cada caso, imprima 'verdadero' si la cadena está balanceada, 'falso' de lo contrario.
     */
     public static boolean isValidString(String s){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && String.valueOf(s.charAt(i)).equals(")") && stack.peek().equals("(")
                    || !stack.isEmpty() && String.valueOf(s.charAt(i)).equals("}") && stack.peek().equals("{")
                    || !stack.isEmpty() && String.valueOf(s.charAt(i)).equals("]") && stack.peek().equals("[")){
                stack.pop();
            }else {
                stack.add(String.valueOf(s.charAt(i)));
            }
        }
        return stack.isEmpty();
    }
}
