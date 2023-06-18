package N_28_POO.Abstraccion;
public class Main {
    public static void main(String[] args) {
        // instacia de la clase Persona
        Persona persona = new Persona();

        // accedemos a uno de sus atributos
        persona.nombre = "Lorenzo"; //inicializamos el atributo del objeto
        // imprimimos por consola ese atributo
        System.out.println(persona.nombre);

        //accedemos a uno de sus metodos
        persona.correr();
    }
}
