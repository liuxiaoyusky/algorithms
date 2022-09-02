package GraphSearchAlgorithmIII;

import java.util.HashSet;
import java.util.Set;

/*
Given a dictionary containing many words, find the largest product of two words’ lengths,
such that the two words do not share any common characters.

Assumptions

    The words only contains characters of 'a' to 'z'
    The dictionary is not null and does not contains null string, and has at least two strings
    If there is no such pair of words, just return 0

Examples

    dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
 */
public class LargestProductOfLength {
    //convert every string to an int where first 26 bits represent if a char exists
    public int largestProduct(String [] dict) {
       int ans = 0;
       int [] ints = new int[dict.length];
       for(int i = 0; i < dict.length; i++) {
           ints[i] = toInts(dict[i]);
       }
       for (int i = 0; i < dict.length; i++) {
           for (int j = i + 1; j < dict.length; j++) {
               if ((ints[i] & ints[j]) == 0) {
                   ans = Math.max(ans, dict[i].length() * dict[j].length());
               }
           }
       }
       return ans;
    }

    private int toInts(String input) {
        int res = 0;
        for (char c : input.toCharArray()) {
            res |= 1 <<(c - 'a');
        }
        return res;
    }

    //---------------------------------------------------------------
    //naive way, convert string to char array for easy comparation
    public int largestProductI(String[] dict) {
        int ans = 0;
        int [][] dicts = new int [dict.length][27];

        //convert string to char array with alphabatic order
        for (int i = 0; i < dict.length; i++) {
            String cur = dict[i];
            dicts[i][26] = cur.length();
            for (int j = 0; j < cur.length(); j++) {
                int index = cur.charAt(j) - 'a';
                dicts[i][index]++;
            }
        }

        //compare between every two string
        for (int i = 0; i < dicts.length; i++) {
            int [] a = dicts[i];
            for (int j = i + 1; j < dicts.length; j++) {
                int [] b = dicts[j];
                boolean sameLetter = false;
                for (int k = 0; k < 26 && !sameLetter; k++) {
                    if (a[k] != 0 && b[k] != 0) {
                        sameLetter = true;
                    }
                }
                if (!sameLetter) {
                    ans = Math.max(ans, a[26] * b[26]);
                }
            }
        }
        return ans;
    }
}
