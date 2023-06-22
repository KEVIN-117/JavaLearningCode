package N_19CODESIGNAL.Introduccion;

import java.util.Arrays;
import java.util.stream.Stream;

public class AddBorder {
    public static void main(String[] args) {
        String[] picture = {"abc", "ded"};
        solution(picture);
    }

    /**
     *
     * @param picture
     * @return
     * @Arrays.stream(picture):
     * <p>
     *     <i>
     *         convierte el array en stream para operar de manera funcional sobre los elementos del array
     *     </i>
     * </p>
     * @.map(item->item.length()):
     * <p>
     *     para cada elemento item del stream, se obtiene su longitud utilizando item.length().Esto transforma el stream de cadenas en un stream de enteros, donde cada entero representa la longitud de una cadena.
     * </p>
     * @.max(Integer::compare):
     * <p>
     *     Utilizando el método max(), se busca el valor máximo en el stream de enteros. En este caso, se utiliza Integer::compare como comparador para determinar el máximo.
     * </p>
     * @.orElse(0):
     * <p>
     *     Este método es utilizado para manejar el caso en el que el stream esté vacío, es decir, si el array picture está vacío. En tal caso, se devuelve el valor por defecto especificado, que en este caso es 0.
     * </p>
     *
     * @Explicacion
     * <h3><i>.map(cadena -> cadena != null ? "*" + cadena + "*" : "*".repeat(maxLargeString+2))</i></h3>
     * <p>
     *     <i>
     *         Aplica una función de mapeo a cada elemento del flujo. La función verifica si el elemento cadena es diferente de null. Si es así, se concatena el asterisco (*) al inicio y al final de la cadena. Si el elemento es null, se utiliza el método repeat para repetir el asterisco tantas veces como la longitud más larga (maxLargeString) más 2.
     *     </i>
     * </p>
     * <h3><i>.toArray(String[]::new)</i></h3>
     * <p>
     *     <i>
     *         Convierte el flujo de elementos resultante en un arreglo de tipo String. El método de referencia String[]::new se utiliza para indicar que se desea obtener un arreglo de String como resultado.
     *     </i>
     * </p>
     */

    static String[] solution(String[] picture) {

        Stream<String> stream = Arrays.stream(picture);
        int maxLargeString = stream
                .map(item ->  item.length())
                .max(Integer::compare)
                .orElse(0);
        picture = Arrays.copyOf(picture, picture.length+2);
        String[] formatterString = Arrays.stream(picture)
                .map(cadena -> cadena != null ? "*" + cadena + "*" : "*"
                        .repeat(maxLargeString+2))
                .toArray(String[]::new);
        String[] resul = new String[formatterString.length];
        resul[0] = formatterString[formatterString.length-1];
        int counter = 1;
        for (int i = 0; i < formatterString.length-1; i++) {
            resul[counter] = formatterString[i];
            counter++;
        }
        return resul;
    }

}
