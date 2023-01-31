package BitwiseOperation;

public class TwoMissingNumbers {
    public static int[] missingNumbers (int [] array) {
        //sanity check
        if (array == null || array.length == 0) {
            return new int [] {0, 1};
        }

//find the xor value of two missing number
        int mix = 0;
        for (int i = 0; i <= array.length + 1; i++) {
            mix ^= i;
            if (i < array.length) {
                mix ^= array[i];
            }
        }

        int rightShift = 0;
        int cur = mix;
        while (cur > 0) {
            if (cur % 2 == 1) {
                break;
            }
            rightShift++;
            cur >>= 1;
        }

        int small = 0;
        for (int i = 0; i <= array.length + 1; i++) {
            if (i >> rightShift % 2 == 1) {
                small ^= i;
            }

            if (i < array.length && array[i]  >> rightShift % 2 == 1) {
                small ^= array[i];
            }
        }

        return new int [] {small, mix ^ small};
    }
}
