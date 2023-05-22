package N_19CODESIGNAL.Introduccion;

import java.util.*;


public class ReverseInParentheses {
    public static void main(String[] args) {
        //System.out.println(solution("foo(bar)baz"));
        //System.out.println(solution("foo(bar)baz(blim)"));
        System.out.println(solution("foo(bar(baz))blim"));
        //System.out.println(solution("(bar)"));
    }
    static String solution(String inputString) {
        HashMap<String, String[]> map = new HashMap<>();
        String[] strings;
        int a, b, j, k;
        String aux;
        a = inputString.indexOf("(");
        b = inputString.indexOf(")");
        while (a >= 0){
            strings = inputString.substring(a+1, b).split("\\p{Punct}");
            System.out.println("sub--> " + inputString.substring(a+1, b));
            System.out.println("Arrays--> " + Arrays.toString(strings));
            map.put(a + " " + b, strings);
            //if (inputString.substring(a+1, b).contains("("))
            //    break;
            a = inputString.indexOf("(", a+1);
            b = inputString.indexOf(")", b+1);
        }
        for (String i : map.keySet())
            System.out.println(i + "--> " + Arrays.toString(map.get(i)));
        /*for (String i : map.keySet()) {
            for (j = 1; j < map.get(i).length; j++) {
                aux = "";
                for (k = map.get(i)[j].length()-1; k >= 0; k--){
                    aux += String.valueOf(map.get(i)[j]).charAt(k);
                }
                map.get(i)[j] = aux;
            }
            strings = i.split(" ");
            aux = inputString.substring(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            System.out.println(Arrays.toString(map.get(i)));
            String join = String.join("", map.get(i));
            inputString = inputString.replace(aux, join);
        }*/
        return inputString.replaceAll("\\p{Punct}", "");
    }
}
