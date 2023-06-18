package N_28_POO.Inheritance.Contructores.ContructorEjemplo3;

public class Clase2 extends Clase1 {
    public Clase2(int n) {
        super(n);
        // error de compilacion en esta clase pues su contructor icluje una llamada al contructor sin parametros de la clase 1 pero ese contructor no existe
        System.out.println("Clase 2");
    }
}
