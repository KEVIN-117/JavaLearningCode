package N_28_POO.Inheritance;

import java.math.BigInteger;

public class Mathematics {

    static int sumar(int a, int b){
        return a+b;
    }

    static double sumar(double a, double b){
        return a+b;
    }

    static BigInteger sumar(BigInteger a, BigInteger b){
        return a.add(b);
    }
}
