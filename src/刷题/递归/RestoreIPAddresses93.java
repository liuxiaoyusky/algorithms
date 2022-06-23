package 刷题.递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses93 {
    /*
    A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and
    255 (inclusive) and cannot have leading zeros.
    For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and
     "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots
 into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

Constraints:
    1 <= s.length <= 20
    s consists of digits only.
     */

    //input string, output:List<String>
    //given:s are digits only

    //base case: if index i at s.length() and count == 4
    //base case: at index i, if count< 4, check if s[i], s[i,i+1], s[i,i+2] are valid address,
    // for every valid address, count++ and go next layer starting with next index
    public List<String> restoreIpAddresses(String s) {
        //corner case
        if (s.length() < 4 || s.length() > 20) {
            return new ArrayList<>();
        }

        List<String> ans = new LinkedList<>();
        int [] curNum = new int[4];
        helper(s, 0, 0, curNum, ans);
        return ans;
    }

    private void helper(String s, int index, int count, int [] curNum, List<String> ans) {
        //base case
        if (index == s.length() && count == 4) {
            String cur = convert(curNum);
            ans.add(cur);
            return;
        }

        //corner case
        if (count >= 4) {
            return;
        }

        if (index >= s.length()) {
            return;
        }

        //general case
        int cur = 0;
        for (int i = 0; i < 3; i++) {
            if (index + i < s.length()) {
                cur = cur * 10 + s.charAt(index + i) - '0';
                if (cur <= 255) {
                    curNum[count] = cur;
                    helper(s,index + i + 1, count + 1, curNum, ans);
                }

                //corner case: if cur == 0, don't keep looking
                if (cur == 0) {
                    break;
                }
            }
        }
    }

    private String convert(int [] curNum) {
        StringBuilder sb = new StringBuilder();
        for (int i : curNum) {
            sb.append(i);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
