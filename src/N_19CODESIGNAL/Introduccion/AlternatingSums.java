package N_19CODESIGNAL.Introduccion;

import java.util.Arrays;

public class AlternatingSums {
    public static void main(String[] args) {
        int[] a = {50, 60, 60, 45, 70};
        System.out.println(Arrays.toString(solution(a)));;
    }
    static int[] solution(int[] a) {
        int teamA = 0;
        int teamB = 0;
        for (int i = 0; i < a.length; i++) {
            if(i%2 == 0){
                teamA+= a[i];
            }else {
                teamB += a[i];
            }
        }
        return new int[]{teamA, teamB};
    }

}
