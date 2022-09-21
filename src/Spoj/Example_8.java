package Spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Example_8 {
    public static void main(String[] args) {
        int[] array = {1,5,4,6,5,8,9,5,3,5};
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        /*int counter = 1;
        int moda = 0;
        int[] saveModas = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            int saveNumber = 0;
            for (int j = 0; j <array.length ; j++) {
                if(array[i] == array[j]){
                    saveNumber ++;
                }
            }
            if (saveNumber > counter){
                saveModas[i] = array[i];
                moda = array[i];
                counter = saveNumber;
            }
            if (counter == saveNumber && moda < array[i]){

            }
        }*/
        int saveCounter = 0;
        int number = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length ; i++) {
            int counter = 0;
            int saveNumber = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]){
                    counter++;
                }
            }
            if (counter > saveCounter){

            }
        }
    }
}
