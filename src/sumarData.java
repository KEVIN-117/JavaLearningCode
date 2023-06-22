import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class sumarData {
    public static String reverseInParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Eliminar el '('
                    for (char ch : sb.toString().toCharArray()) {
                        stack.push(ch); // Revertir y agregar los caracteres a la pila
                    }
                }
            } else {
                stack.push(c); // Agregar otros caracteres a la pila
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString(); // Revertir el resultado final
    }

    public static void main(String[] args) {
        String input = "(bar)baz(blim)";
        String output = reverseInParentheses(input);
        System.out.println(output);
    }
}