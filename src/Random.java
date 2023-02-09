import javax.tools.FileObject;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Random {
    private static File file = new File(".\\writeData.txt");
    private static int[][] matrix;
    private static int item;
    public static void main(String[] args) throws Exception {


        int[][] matrix = new int[100][100];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random()*100)+1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                item = matrix[i][j];
                saveDataToFile(String.valueOf(item).toString());
            }
        }

    }
    static public void saveDataToFile(String item ) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(item);

        fileOutputStream.close();
        objectOutputStream.close();
    }
    public void loadData() throws Exception{
        if (file.exists()){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        }else {

        }
    }
}
