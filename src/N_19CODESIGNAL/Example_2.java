package N_19CODESIGNAL;

public class Example_2 {
    public static void main(String[] args) {
        System.out.println(fun("Eye"));
    }
    static boolean fun(String text){
        String[] save = text.toLowerCase().split("");
        String palindrome = "";
        for (int i = save.length-1; i>-1 ; i--) {
            palindrome += save[i];
        }
        if (text.toLowerCase().equals(palindrome))
            return true;
        else
            return false;
    }
}
