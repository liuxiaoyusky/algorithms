package CrossTrainingDIY;

public class ArrayHopperIV {
    public int minJump(int[] array, int index) {
        // start with an m that m[i] is the min step from i to right most
        int [] m = new int [array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            //cannot jump to right most from here
            m[i] = -1;

            //can jump in one step
            if (array[i] + i >= array.length - 1) {
                m[i] = 1;
                continue;
            }

            //jump to somewhere 1 step away
            for (int j = i + 1; j <= i + array[i]; j++) {
                //corner case, in bound
                if (j >= array.length) {
                    break;
                }

                //reachable from j to right most
                if (m[j] != -1 && (m[i] == -1 || m[j] + 1 < m[i])) {
                    m[i] = m[j] + 1;
                }
            }
        }


        //start from arbitrary location

        int left = index;
        int right = index;
        //if cannot jump in one step, keep discorvering left
        int steps = m[index];
        boolean found = m[index] != -1;
        int extraStep = 0;
        while (!found || extraStep == 0) {
            for (int i = right; i >= left; i--) {
                //corner case: out of bound
                if (i < 0) {
                    return -1;
                }

                if (m[i] == -1) {
                    continue;
                }

                if (i == index) {
                    continue;
                }

                if (steps == -1 || m[i] + extraStep < steps) {
                    steps = m[i] + extraStep;
                }
            }
            right = extraStep == 0 ? Math.min(right + array[right], array.length - 1) : left;
            left = left - array[left];
            //stuck in 0s
            if (array[left] == 0) {
                return steps;
            }
            extraStep++;
        }



        return steps;
    }
}
