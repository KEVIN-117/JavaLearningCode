package N_8_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//the tree is:
/*
                                                   (3)
                                      ____________/   \____________
                                      |                           |
                                     (2)                         (6)
                            ________/   \________       ________/   \________
                            |                   |       |                   |
                           (0)                 (1)     (5)                 (7)
                                                \                           \
                                                (4)                         (8)
 */
public class Example_4 {
    static  int[][] matrix;
    static int lengthMatrix;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        lengthMatrix = 9;
        matrix = new int[lengthMatrix][lengthMatrix];
        /*for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j]= input.nextInt();
            }
        }*/
        matrix[3][2] = 1; matrix[3][6] = 1;
        matrix[2][0] = 1; matrix[2][1] = 1;
        matrix[6][5] = 1; matrix[6][7] = 1;
        matrix[1][4] = 1; matrix[7][8] = 1;
        System.out.println("The tree is:");
        depth(3);
        System.out.println();
        anch(3);

    }
    static void depth(int root){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        while (!stack.isEmpty()){
            int x = stack.pop();

            int counter = 0;
            for (int i = matrix.length-1; i >= 0 ; i--) {
                if (matrix[x][i] == 1){
                    stack.push(i);
                    counter++;
                }
            }
            if (counter == 0){
                System.out.print(x + " ");
            }
        }
    }

    static void anch(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int x = queue.remove();
            int counter = 0;
            for (int i = 0; i < matrix.length ; i++) {
                if (matrix[x][i] == 1){
                    queue.add(i);
                    counter++;
                }
            }
            if (counter == 0){
                System.out.print(x + " ");
            }
        }
    }
}
