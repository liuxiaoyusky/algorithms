package OA.Tiktok;

import java.util.ArrayList;
import java.util.List;

public class IncrementalMemoryLeak {
    /*
    Jina recently got a computer with two memory sticks. The computer will allocate requested moemory from the largest
    available memory stick if possible (or from the first memory stick if both have the same available
    memory), if neither of these two memory sticks has enough available memory, it will cause the cumputer
    Out of Memory(a.k.a OOM).

    Jina is so exciting and writes down a hello world program, but soon jina observes a memory leak on her program,
    her program will allocate i bytes at the i-th second starting from when the program started. Jina is very curious
    when the computer will be OOM after starting her program and the available memory of each memory stick when OOM.
    Can you help her figure it out?

    Input: two int, M1 M2
    Output: int, second that OOM
    Limits: 1<= M1,M2 <= 10^18


    Example:
    input 2 2
    Output: 3 1 0 (OOM at 3 second, with M1 remains 1 and M2 remains 0)

    input 8 11
    Output: 6 0 4
     */

    //solution2 use math to find the second
    public static List<Integer> incrementalMemoryLeakII(int m1, int m2){
        int start = 0;
        int [] ans = new int[3];
        ans[0] = 1;//the next cost
        ans[1] = m1;
        ans[2] = m2;

        ans = cutFront(ans);

        if (m1 >= m2) {
            //next cut on m1
            int m1_sec_before_OOM = alterCut(ans,1,ans[0]);
            int m2_sec_before_OOM = alterCut(ans,2,ans[0] + 1);
            ans[0] = Math.min(m1_sec_before_OOM,m2_sec_before_OOM) + 2;
        } else {
            int m1_sec_before_OOM = alterCut(ans,1,ans[0] + 1);
            int m2_sec_before_OOM = alterCut(ans,2, ans[0]);
            ans[0] = Math.min(m1_sec_before_OOM,m2_sec_before_OOM) + 2;
        }

        List<Integer> res = new ArrayList<>();
        res.add(ans[0]);
        res.add(ans[1]);
        res.add(ans[2]);
        return res;
    }


    //take a memory, now the memory will be cut with an Arithmetic sequence with difference of two
    //find the second before memory leak(the sum <= memory)
    private static int alterCut (int [] ans, int memoryIndex, int n) {
        //start from start = n, n + (n+2) + (n+4) + .... + (n + 2k) = memory
        int a = 1;
        int b = n + 1;
        int c = n - ans[memoryIndex];

        int k = (int) (- b + Math.sqrt(b * b - 4 * a * c)) / 2;
        ans[memoryIndex] = ans[memoryIndex] - (n + k) * (k + 1);
        return ans[0] + 2 * k;
    }

    //take two memory, find the seconds need to alternate. Stop before the alternate (sum < difference)
    private static int [] cutFront(int [] ans) {
        int difference = Math.abs(ans[1] - ans[2]);
        //corner case
        if (difference == 0) {
            return ans;
        } else if (difference == 1) {
            ans[0] = 2;
            if (ans[1] < ans[2]) {
                ans[2]--;
            } else {
                ans[1]--;
            }
            return ans;
        }

        //to make sure sum < difference
        difference--;
        //fomula 1 + 2 + ... n = (1+n)n/2 = d, then n = (-1 + sqrt(1+8d))/2
        int n = (int) ((-1 + Math.sqrt(1 + 8 * difference))/2);//skip the non-integer part
        ans[0] = n + 1;
        if (ans[1] < ans[2]) {
            ans[2] = ans[2] - (int) (1 + n) * n /2;
        } else {
            ans[1] = ans[1] - (int) (1 + n) * n /2;;
        }
        return ans;
    }

    //-----------------------------------------------------------------------
    //Solution 1 while loop
    public static List<Integer> incrementalMemoryLeakI(int m1, int m2) {
        int [] ans = new int[3]; // 0:second 1:m1 2:m2
        ans[1] = m1;
        ans[2] = m2;
        while (ans[1] >= 0 && ans[2] >= 0) {
            ans[0]++;
            if (ans[1] >= ans[2]) {
                ans[1] -= ans[0];
            } else {
                ans[2] -= ans[0];
            }
        }

        if (ans[1] < 0) {
            ans[1] += ans[0];
        } else {
            ans[2] += ans[0];
        }

        List<Integer> res = new ArrayList<>();
        res.add(ans[0]);
        res.add(ans[1]);
        res.add(ans[2]);
        return res;
    }

    public static void main(String [] args) {
        System.out.println(IncrementalMemoryLeak.incrementalMemoryLeakII(2,2));
        System.out.println(IncrementalMemoryLeak.incrementalMemoryLeakII(8,11));
    }
}