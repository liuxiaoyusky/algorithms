package OA.Mathworks;

import java.util.Stack;

public class SmallestSubsequence {
    public String smallestSubsequence(String S) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        int [] seen = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < S.length(); ++i) {
            int c = S.charAt(i) - 'a';
            int saw  = seen[c];
            if (seen[c] > 0) {
                continue;
            } else {
                seen[c]++;
            }

            while (!stack.isEmpty()) {
                int lastChar = stack.peek();
                if (lastChar > c && i < last[lastChar]) {
                    seen[lastChar] = 0;
                    stack.pop();
                    if (!stack.isEmpty()) {
                        lastChar = stack.peek();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char)('a' + i));
        return sb.toString();
    }
}
