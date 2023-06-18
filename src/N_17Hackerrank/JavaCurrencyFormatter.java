package N_17Hackerrank;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @description: <div>
 *     Dado un número de <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">doble precisión</a>,
 *     <b><i>payment</i></b>, que denota una cantidad de dinero, use el
 *     método <a href="https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getCurrencyInstance-java.util.Locale-">getCurrencyInstance</a>
 *     de la clase <a href="https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html">NumberFormat</a> para convertir <b><i>payment</i></b> en los
 *     formatos de moneda estadounidense, india, china y francesa. Luego imprima los valores formateados de la
 *     siguiente manera
 *     <b>
 *         <p>US: formattedPayment</p>
 *         <p>India: formattedPayment</p>
 *         <p>China: formattedPayment</p>
 *         <p>France: formattedPayment</p>
 *     </b>
 *
 *     <p>
 *         donde <b>formattedPayment</b> esta formateado deacuerdo con la moneda de la <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html">configuracion regional</a> adecuada,
 *         <h2>Nota</h2>
 *         <P>
 *             India no tiene una configuración regional integrada, por lo que debe <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html#Locale-java.lang.String-java.lang.String-">crear una</a> en la que esté el idioma en(es decir, inglés).
 *         </P>
 *     </p>
 *
 * </div>
 * @FormatoDeEntrada: <p>
 *     Un solo número de doble precisión que denota <b><i>payment</i></b>.
 * </p>
 * @Restricciones: <p>
 *     0 <= <b><i>payment</i></b> <= 10<sup>9</sup>
 * </p>
 *
 * @FormatoDeSalida: <p>
 *     En la primera línea, escriba <b><i>US</i></b>: <b><i>u</i></b> donde <b><i>u</i></b> es <b><i>payment</i></b> formateado para moneda estadounidense.
 *     <p>y haci sucesivamente para las monedas que se le pide</p>
 * </p>
 *
 * @EntradaDeMuestra: <div>
 *     <ul>
 *         <h3>Entrada:</h3>
 *         <li>12324.134</li>
 *         <h3>Salida:</h3>
 *         <li>US: $12,324.13</li>
 *         <li>India: Rs.12,324.13</li>
 *         <li>France: 12 324,13 €</li>
 *         <li>China: ￥12,324.13</li>
 *     </ul>
 * </div>
 *
 * @Explicacion: <div>
 *     Cada línea contiene el valor de <b><i>payment</i></b> formateado de acuerdo con las respectivas monedas de los cuatro países.
 * </div>
 */
public class JavaCurrencyFormatter {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Double amount = scanner.nextDouble();

        Formatter US = new Formatter(amount, "en", "us");
        Formatter IN = new Formatter(amount, "HI", "IN");
        Formatter CN = new Formatter(amount, "ZH", "CN");
        Formatter FR = new Formatter(amount, "FR", "FR");


        System.out.println(US.getPayment());
        System.out.println(IN.getPayment());
        System.out.println(CN.getPayment());
        System.out.println(FR.getPayment());
        /*
        $12,324.13
        R$ 12.324,13
         */
    }
}

class Formatter{
    private Double amount;
    private String language;
    private String country;

    private Format format;
    private Locale locale;

    public Formatter(Double amount, String language, String country){
        this.amount = amount;
        this.language = language;
        this.country = country;
        this.locale = new Locale(this.language, this.country);
        this.format = NumberFormat.getCurrencyInstance(this.locale);
    }

    /**
     *
     * @return the currency tipe
     * @ConfiguracionRegional: <h3>configuracion regional de idioma inglés en India</h3>
     * @Eplicacion:
     * <div>
     *     <p>
     *         Utilizar la clase
     *         <b><i> java.util.Locale </i></b> y especificar el idioma y el país correspondientes
     *         <ul>
     *             <h6>Contructor a utilizar</h6>
     *             <li><b>public Locale(String language,String country)</b></li>
     *             <li>Construya una configuración regional a partir del idioma y el país. Este constructor normaliza el valor del idioma en minúsculas y el valor del país en mayúsculas.</li>
     *         </ul>
     *     </p>
     * </div>
     *
     * @CambiarElSymboloDeUnaMoneda:
     * <div>
     *     <h3>como cambir el symbolo de la moneda</h3>
     *     <p>
     *         puedes utilizar la clase
     *         <b><i> java.text.DecimalFormatSymbols </i></b> y establecer el nuevo símbolo de moneda para la configuración
     *         regional específica
     *     </p>
     * </div>
     */
    public String setPayment(){
        if (this.locale.getDisplayCountry().equals("India")){
            this.locale = new Locale("en", "IN");
            this.format = NumberFormat.getCurrencyInstance(this.locale);
            // Cambiar el símbolo de la moneda
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(this.locale);
            symbols.setCurrencySymbol("Rs.");

            // Crear un formateador de moneda con el nuevo símbolo
            DecimalFormat currencyFormatter = (DecimalFormat) DecimalFormat.getCurrencyInstance(this.locale);
            currencyFormatter.setDecimalFormatSymbols(symbols);
            // Formatear un valor de moneda
            return currencyFormatter.format(this.amount);
        }
        return this.format.format(this.amount);
    }

    public String getPayment(){
        return (this.locale.getDisplayCountry().equals("United States"))? "US: " + setPayment(): this.locale.getDisplayCountry() + ": " + setPayment();
    }
}


