package CrossTrainingIV;

public class KthSmallestInSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        int f = Math.min(a.length, k);
        int s = Math.min(b.length, k);

        //f + s - k is all we want to reduce
        int reduceRate = Math.max((f + s - k) / 2, 1);
        while (f + s > k) {
            //if both in range
            int ff = f - reduceRate;
            int ss = s - reduceRate;
            //compare
            if(f > 0 && s > 0) {
                if (a[ff] < b[ss]) {
                    s = ss;
                } else {
                    f = ff;
                }
            } else if (f > 0) {
                //s = 0, we can directly return our value
                return a[f - 1];
            } else {
                return b[s - 1];
            }


            //reducing searching space
            if (reduceRate > 1) {
                reduceRate /= 2;
            }
        }
        if (f > 0 && s > 0) {
            //now f + s = k,find the largest value of a[f] and b[s] and return
            return a[f - 1] < b[s - 1] ? b[s - 1] : a[f - 1];
        } else if (f > 0) {
            //s = 0, we can directly return our value
            return a[f - 1];
        } else {
            return b[s - 1];
        }
    }
    //---------------------------------------------------------------
    //naive way, two pointers, move the smaller one
    public int kthI(int[] a, int[] b, int k) {
        int first = 0;
        int second = 0;
        int count = 1;//compare the count th value
        int ans = 0;
        while (count <= k) {
            //both in range
            if (first < a.length && second < b.length) {
                //compare
                if (a[first] < b[second]) {
                    ans = a[first];
                    first++;
                } else {
                    ans = b[second];
                    second++;
                }
            } else if (first < a.length) {
                ans = a[first];
                first++;
            } else {
                ans = b[second];
                second++;
            }
            count++;
        }
        return ans;
    }
}
