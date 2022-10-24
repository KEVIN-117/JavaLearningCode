package N_17Hackerrank.KitPreparationOneWeek.DayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoutingSort_1 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = x.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            int counter = 0;

                if (array[i] == array[i+1]){
                    counter++;
                }

            list.add(counter);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
