package OA.Tiktok.NOV2022;

import java.util.Arrays;

public class WaterTruck {
    //sort it by starting time
    class Range implements Comparable<Range> {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            if (o.start == this.start) {
                return 0;
            }

            return this.start < o.start ? -1 : 1;
        }
    }

    public int water(int [][] array, int n) {
        Range [] ranges = new Range[array.length];
        for (int i = 0; i < array.length; i++) {
            int [] a = array[i];
            ranges[i] = new Range(a[0], a[1]);
        }
        Arrays.sort(ranges);

        int cost = 0;
        int prev = 0;
        for (Range r : ranges) {
            if (r.start > prev) {
                cost += r.start - prev;
            }
            if (r.end > prev) {
                prev = r.end;
            }
        }

        if (prev < n - 1) {
            cost += n - 1 - prev;
        }

        return cost;
    }
}
