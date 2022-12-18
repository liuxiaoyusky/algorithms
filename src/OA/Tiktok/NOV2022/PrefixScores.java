package OA.Tiktok.NOV2022;

import java.util.List;

public class PrefixScores {

    /*
     * Complete the 'getPrefixScores' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> getPrefixScores(List<Integer> arr) {
        Integer[] array = new Integer[arr.size()];
        array = arr.toArray(array);
        int max = array[0];
        Integer [] ans = new Integer[arr.size()];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            int newMax = max;
            Integer[] m = array.clone();
            int total = 0;
            for (int j = 0; j <= i; j++) {
                m[j] += newMax;
                if (m[j] > newMax) {
                    newMax = m[j];
                }
                total += m[j];
                total %= 1_000_000_007;
            }

            ans[i] = total;
        }

        return List.of(array);

    }
}