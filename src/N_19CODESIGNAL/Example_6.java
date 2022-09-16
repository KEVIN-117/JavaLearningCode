package N_19CODESIGNAL;

import java.util.Arrays;

public class Example_6 {
    public static void main(String[] args) {
        int[] seq = {3, 6, 5, 8, 10, 20, 15};
        System.out.println(fun(seq));
    }
    static boolean fun(int[] sequence){
        int counter =0;
        for (int i = 0; i < sequence.length-1; i++){
            if (sequence[i] == sequence[i+1]){
                return false;
            }
            if (sequence[i] > sequence[i+1]){
                int aux = sequence[i];
                sequence[i] = sequence[i+1];
                sequence[i+1] = aux;
                counter++;
            }
            if (counter == 2){
                break;
            }
        }
        for (int i = 0; i < sequence.length-1; i++){
            if (sequence[i] > sequence[i+1]){
                return false;
            }
        }
        return true;
    }
}
