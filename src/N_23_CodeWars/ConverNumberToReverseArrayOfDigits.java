package N_22_CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConverNumberToReverseArrayOfDigits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize(35231)));
        int number = 35231;
        System.out.println(Arrays.toString(digitize(number)));
    }
    public static int[] digitize(long n){
        int[] list = new int[String.valueOf(n).length()];
        int index = 0;
        while (n != 0){
            list[index] = (int) (n%10);
            n = n/10;
            index++;
        }
        return list;
    }
    public static int[] digitize(int n){
        return new StringBuilder().append(n)
                .reverse().chars().map(Character::getNumericValue).toArray();
    }
}
