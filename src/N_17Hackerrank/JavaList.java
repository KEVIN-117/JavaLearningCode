package N_17Hackerrank;

import N_8_Tree.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        CreateList list = new CreateList();

        Integer N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            list.addElements(scanner.nextInt());
        }
        System.out.println(list.getElements());
        int Q = scanner.nextInt();

        for (int i = 0; i < Q; i++) {
            String option = scanner.next();
            switch (option){
                case "Insert" ->{
                    Integer index = scanner.nextInt();
                    Integer item = scanner.nextInt();
                    list.insertElement(index, item);
                    System.out.println(list.getElements());
                    break;
                }
                case "Delete" ->{
                    list.deleteElement(scanner.nextInt());
                    System.out.println(list.getElements());
                    break;
                }
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }

        System.out.println(list.getElements());


    }
}


class CreateList{
    private ArrayList<Integer> list;
    public CreateList(){
        this.list = new ArrayList<>();
    }

    public void addElements(Integer item){
        this.list.add(item);
    }

    public void deleteElement(int index){
        this.list.remove(index);
    }

    public void insertElement(Integer index, Integer item){
        this.list.add(index, item);
    }

    public String getElements(){
        String aux = "";
        for(Integer i : list){
            aux += i + " ";
        }
        return aux.trim();
    }
}
