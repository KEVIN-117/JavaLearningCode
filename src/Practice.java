import java.util.*;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> stack = new LinkedList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String[] strings = input.next().split("");
            for (int j = 0; j < strings.length-1; j++) {
                stack.add(strings[j]+strings[j+1]);
            }
        }
        while (!stack.isEmpty()){
            if (Integer.parseInt(stack.peek()) <= 10)
                System.out.println(Integer.parseInt(stack.remove()));
            else {
                Stream<String> stream = Arrays.stream(stack.remove().split(""));
                stream.forEach(item -> System.out.println(item));
            }


        }
    }
}
