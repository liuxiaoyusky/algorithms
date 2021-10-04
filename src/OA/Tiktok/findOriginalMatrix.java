package OA.Tiktok;

import java.util.ArrayList;
import java.util.List;

public class findOriginalMatrix {
    public static List<List<Integer>> findOriginalMatrix(List<List<Integer>> input) {
        //init
        int m = input.size();
        int n = input.get(0).size();

        //find original
        for (int j = m - 1; j > 0; j--) {
            for (int i = n - 1; i > 0; i--) {
                input.get(i).set(j,input.get(i).get(j) - input.get(i - 1).get(j) - input.get(i).get(j - 1)
                        + input.get(i - 1).get(j - 1));
            }
        }

        for (int j = m - 1; j > 0; j--) {
            input.get(0).set(j,input.get(0).get(j) - input.get(0).get(j - 1));
        }

        for (int i = n - 1; i > 0; i--) {
            input.get(i).set(0,input.get(i).get(0) - input.get(i - 1).get(0));
        }

        return input;
    }

    public static void main(String [] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(3);
        b.add(4);
        b.add(10);
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(a);
        matrix.add(b);
        System.out.println(findOriginalMatrix(matrix));
    }
}
