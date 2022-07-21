package 刷题.哈希表;

import java.util.*;

/*
Given a string array words, return an array of all characters
that show up in all strings within the words (including duplicates).
You may return the answer in any order.



Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]



Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists of lowercase English letters.


 */
public class FindCommonCharacters1002 {
    public List<String> commonChars(String[] words) {
        //corner case
        if (words == null || words.length  == 0) {
            return new LinkedList<>();
        }
        int [] chars = new int[26];
        convert(chars, words[0]);
        for(int i = 1; i < words.length; i++) {
            check(words[i],chars);
        }
        return tolist(chars);
    }

    private void convert(int [] chars, String cur) {
        for (int i = 0; i < cur.length(); i++) {
            chars[cur.charAt(i) - 'a']++;
        }
    }

    private void check(String cur, int [] charss) {
        int [] chars = new int[26];
        for (int i = 0; i < cur.length(); i++) {
            chars[cur.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            charss[i] = Math.min(charss[i], chars[i]);
        }
    }

    private List<String> tolist(int [] chars) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            while (chars[i] > 0) {
                chars[i]--;
                char c = (char) (i + 'a');
                list.add(""+c);
            }
        }
        return list;
    }
}
