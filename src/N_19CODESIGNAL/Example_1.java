package N_19CODESIGNAL;

public class Example_1 {
    public static void main(String[] args) {
        System.out.println(fun(1700));
    }
    static int fun(int year){
        Double save = (double)(year)/100;
        String[] array = String.valueOf(save).split("\\p{Punct}");
        if (Integer.parseInt(array[1]) != 0){
            year = Integer.parseInt(array[0])+1;
        }else {
            year = Integer.parseInt(array[0]);
        }
        return year;
    }
}
