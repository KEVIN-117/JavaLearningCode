package N_17Hackerrank;

import java.util.HashMap;
import java.util.Scanner;


/**
 * @description:
 * <div>
 *     <p>
 *         Se le entrega una guía telefónica que consta de los nombres de las personas y su número de teléfono. Después de eso, se le dará el nombre de una persona como consulta. Para cada consulta, imprima el número de teléfono de esa persona.
 *     </p>
 *     <h3>Formato de entrada:</h3>
 *     <p>
 *         La primera línea tendrá un número entero <b><i>n</i></b> que indicará el número de entradas en la guía telefónica. Cada entrada consta de dos líneas: un nombre y el número de teléfono correspondiente.
 *     </p>
 *     <p>
 *         Después de estos, habrá algunas consultas. Cada consulta contendrá el nombre de una persona. Lea las consultas hasta el final del archivo.
 *     </p>
 *     <h3>Restricciones:</h3>
 *     <p>
 *         El nombre de una persona consta solo de letras <b>minúsculas</b> en <b>inglés</b> y puede tener el formato
 *         <b><i>'first-name last-name'</i></b> o el formato <b><i>'first-name'</i></b>.
 *         Cada número de teléfono tiene exactamente <b><i>8 dígitos</i></b> sin ceros a la izquierda.
 *     </p>
 *     <ul>
 *         <li>1 <= <b><i>n</i></b> <= 100000</li>
 *         <li>1 <= <b><i>Query</i></b> <= 100000</li>
 *     </ul>
 *     <h3>Formato de Salida:</h3>
 *     <p>
 *         Para cada caso, imprima <b><i>"No encontrado"</i></b> si la persona no tiene ninguna entrada en la guía
 *         telefónica. De lo contrario, escriba el <b><i>nombre</i></b> y el <b><i>número de teléfono</i></b>
 *         de la persona. Consulte la salida de muestra para conocer el formato exacto.
 *     </p>
 *
 *     <h3>Entrada de muestra</h3>
 *     <ul>
 *         <li>3</li>
 *          <li>uncle sam</li>
 *          <li>99912222</li>
 *          <li>tom</li>
 *          <li>11122222</li>
 *          <li>harry</li>
 *          <li>12299933</li>
 *          <li>uncle sam</li>
 *          <li>uncle tom</li>
 *          <li>harry</li>
 *     </ul>
 *     <h3>Salida de muestra</h3>
 *      <ul>
 *          <li>uncle sam=99912222</li>
 *          <li>Not found</li>
 *          <li>harry=12299933</li>
 *      </ul>
 * </div>
 *
 */
public class JavaMap {
    public static void main(String[] args) {
        HashMap<String, Client> clients = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            int number = scanner.nextInt();
            Client client = new Client(name, number);
            clients.put(client.getName(), client);
            scanner.nextLine();
        }
        while (scanner.hasNext()){
            String name = scanner.nextLine();
            if (clients.get(name) != null){
                System.out.println(clients.get(name).getName() + "=" + clients.get(name).getPhone());
            }else {
                System.out.println("Not found");
            }
        }
        System.out.println(clients);
    }
}

class Client{
    private String name;
    private String lastName = "";
    private Integer phone;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Client(String name, Integer phone){
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
