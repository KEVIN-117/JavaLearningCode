package N_17Hackerrank.Mathematics;

import java.util.ArrayList;
import java.util.List;

public class FindThePoint {
    public static List<Integer> findPoint(int px, int py, int qx, int qy) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        list.add((qx * 2) - px);
        list.add((qy * 2) - py);
        return list;
    }

    public static void main(String[] args) {
        findPoint(0 , 0, 1, 1);
        findPoint(1 , 1, 2, 2);
    }
}
