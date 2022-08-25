package DFSII;

import java.util.LinkedList;
import java.util.List;

/*
Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
Input:  ”25525511135”
Output: [“255.255.11.135”, “255.255.111.35”]
 */
public class RestoreIPAddress {
    public List<String> Restore(String ip) {
        List<String> ans = new LinkedList<>();
        //corner case
        if (ip == null || ip.length() <= 3) {
            return ans;
        }
        char [] array = ip.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        helper(array, 1, 3, array[0] - '0', sb, ans);
        return ans;
    }

    //two choices:
    //1. add array[i] to current count, check its value in [0, 255]
    //2. add'.' to sb, start a new count
    private void helper(char [] array, int index, int count, int curValue, StringBuilder sb,
                        List<String> ans) {
        //base case
        if (index == array.length) {
            if (count == 0) {
                ans.add(new String(sb));
            }
            return;
        }

        //1.add to cur count, 01 is illegal
        int num = array[index] - '0';
        int newValue = curValue * 10 + num;
        if (curValue != 0 && newValue >= 0 && newValue <= 255) {
            sb.append(num);
            helper(array, index + 1, count, newValue, sb, ans);

            //backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        //2/add to new count
        if (count > 0) {
            sb.append('.');
            sb.append(num);
            helper(array, index + 1, count - 1, num, sb, ans);

            //backtrack
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
