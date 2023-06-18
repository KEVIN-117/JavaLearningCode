package N_17Hackerrank;


import java.util.*;

/**
 * @Descripcion:
 * <p>
 *     Se le proporciona una lista de información del estudiante: <b>identificación</b>, <b>nombre</b> y <b>CGPA</b>. Su tarea es reorganizarlos de acuerdo con su CGPA en orden decreciente. Si dos estudiantes tienen el mismo CGPA, organícelos según su primer nombre en orden alfabético. Si esos dos estudiantes también tienen el mismo nombre, ordénelos según su ID. No hay dos estudiantes con la misma identificación.
 * </p>
 * @Sugerencia:
 * <p>
 *      puede usar comparadores para ordenar una lista de objetos. Consulte <a href="http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html">documentos de Oracle </a> para obtener información sobre los comparadores.
 * </p>
 * @FormatoDeEntrada:
 * <p>
 *     La primera línea de entrada contiene un número entero. <b>N</b>  que representa el número total de estudiantes. El siguiente <b>N</b> líneas contiene una lista de información de los estudiantes en la siguiente estructura:
 * </p>
 * <pre>ID  Name  CGPA</pre>
 *
 * @Restriccion:
 * <ul>
 *      <li><b><i>2</i></b> <= <b><i>N</i></b> <= <b><i>1000</i></b></li>
 *      <li><b><i>0</i></b> <= <b><i>ID</i></b> <= <b><i>100000</i></b></li>
 *      <li><b><i>5</i></b> <= <b><i>|Name|</i></b> <= <b><i>30</i></b></li>
 *      <li><b><i>0</i></b> <= <b><i>CGPA</i></b> <= <b><i>4.00</i></b></li>
 * </ul>
 *
 * <ul>
 *     <li>El nombre contiene solo letras minúsculas en inglés.</li>
 *     <li>El ID contiene solo números enteros sin ceros a la izquierda</li>
 *     <li> El CGPA contendrá, como máximo, 2 dígitos después del punto decimal.</li>
 * </ul>
 *
 * @FormatoDeSalida:
 * <p>
 *     Después de reorganizar a los estudiantes de acuerdo con las reglas anteriores, escriba el primer nombre de cada estudiante en una línea separada.
 * </p>
 * @Ejemplo:
 * <h3>Entrada</h3>
 * <ul>
 *      <li>5</li>
 *      <li>33 Rumpa 3.68</li>
 *      <li>85 Ashis 3.85</li>
 *      <li>56 Samiha 3.75</li>
 *      <li>19 Samara 3.75</li>
 *      <li>22 Fahim 3.76</li>
 * </ul>
 * <h3>Salida</h3>
 * <ul>
 *      <li>Ashis</li>
 *      <li>Fahim</li>
 *      <li>Samara</li>
 *      <li>Samiha</li>
 *      <li>Rumpa</li>
 * </ul>
 */
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new CheckerStudent());
        for(Student st: studentList){
            System.out.println(st.getId() + " " + st.getName() + " " + st.getCgpa());
        }
    }
}

class CheckerStudent implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getCgpa() != o2.getCgpa()){
            return Double.compare(o2.getCgpa(), o1.getCgpa());
        }if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        }else{
            return o2.getId() - o1.getId();
        }
    }
}

class Student{
    private Integer id;
    private String name;
    private Double cgpa;

    public Student(Integer id, String name, Double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
}


/*
33 Rumpa 3.68
85 Ashis 3.85
19 Samara 3.75
56 Samiha 3.75
22 Fahim 3.76


85 Ashis 3.85
22 Fahim 3.76
33 Rumpa 3.68
19 Samara 3.75
56 Samiha 3.75

33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

19 Samara 3.75
22 Fahim 3.76
33 Rumpa 3.68
56 Samiha 3.75
85 Ashis 3.85
 */