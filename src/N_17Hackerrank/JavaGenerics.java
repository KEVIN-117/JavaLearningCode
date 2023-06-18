package N_17Hackerrank;

/**
 * @Descripcion:
 * <p>
 *     Los métodos genéricos son una forma muy eficiente de manejar múltiples tipos de datos usando un solo método. Este problema pondrá a prueba su conocimiento sobre los métodos genéricos de Java.
 * </p>
 * <p>
 *     Digamos que tiene una matriz de enteros y una matriz de cadenas. Tienes que escribir un <b>solo</b> método printArray que pueda imprimir todos los elementos de ambas matrices. El método debería poder aceptar matrices de enteros o matrices de cadenas.
 * </p>
 * <p>
 *     Se le da código en el editor. Complete el código para que imprima las siguientes líneas:
 * </p>
 */
public class JavaGenerics {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        printer.printArray(intArray);
        printer.printArray(stringArray);
    }
}

class Printer <T>{
    public void printArray(T[] array){
        for (T item: array) {
            System.out.println(item);
        }
    }
}
