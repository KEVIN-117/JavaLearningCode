package N_19CODESIGNAL.Introduccion;

import java.util.Arrays;
import java.util.function.Function;

public class AreSimilar {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3}, new int[]{1,2,3}));//true
        System.out.println(solution(new int[]{2,1,3}, new int[]{1,2,3}));//true
        System.out.println(solution(new int[]{1,2,2}, new int[]{2,1,1}));//false
        System.out.println(solution(new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279},
                new int[]{832, 570, 148, 998, 533, 561, 455, 147, 894, 279}));//false
        
    }
    static boolean solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.compare(a,b));
        return Arrays.compare(a,b) == 0;
    }

    static void solution(Function<String, String> a, Function<Integer, String> b){
        System.out.println(a.apply(b.apply(10)));
    }

}
