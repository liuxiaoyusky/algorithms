package DynamicProgramming.dp1;
/*
Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

Examples

    0th fibonacci number is 0
    1st fibonacci number is 1
    2nd fibonacci number is 1
    3rd fibonacci number is 2
    6th fibonacci number is 8

Corner Cases

    What if K < 0? in this case, we should always return 0.
    Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.
 */
public class FibonacciNumber {
    public long fibonacci(int K) {
        //base case
        if (K <= 0) {
            return 0;
        }

        long [] memory = new long [K + 1];
        memory[0] = 0;
        memory[1] = 1;

        int cur = 2;
        while (cur <= K) {
            memory[cur] = memory[cur - 2] + memory[cur - 1];
            cur++;
        }

        return memory[K];
    }
}
