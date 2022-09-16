package Sis_211;

import java.util.Arrays;

public class Example_3 {
    public static void main(String[] args) {
        int[] array = {2,2,3,3,3,4,53};
        counterNumbers(array);
    }
    public static void counterNumbers(int[] listNumber){
        int counter = 0;
        Arrays.sort(listNumber);
        int sux = listNumber[0];
        for (int i = 0; i < listNumber.length; i++) {
            if (sux == listNumber[i]){
                counter++;
            }else {
                System.out.print(counter + " ");
                counter = 1;
                sux = listNumber[i];
            }
        }
        System.out.println(counter);
    }
}
