package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

/*
two string s and t, return the minimum window substring, such that every character
in t is included in the window. Return empty if not exist.
 */
public class StringContainingOther {
    public String findWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = buildMap(t);

        int slow = 0;
        int start = -1;
        int match = 0;
        int shortest = Integer.MAX_VALUE;
        for (int fast = 0; fast < s.length(); fast++) {
            //step 1: add fast
            char cur = s.charAt(fast);
            Integer count = map.get(cur);

            //count == null, 如果t不存在当前char
            if (count != null) {
                if (count == 1) {
                    match++;
                }
                map.put(cur, count - 1);
            }

            //step 2: move slow,缩短左边到第一个不满足的地方
            while (match == map.size()) {
                if (shortest > fast - slow + 1) {
                    shortest = fast - slow + 1;
                    start = slow;
                }
                cur = s.charAt(slow);
                count = map.get(cur);
                if (count != null) {
                    if (count == 0) {
                        match--;
                    }
                    map.put(cur,count + 1);
                }
                slow++;
            }
        }
        return shortest == Integer.MAX_VALUE ? "" : s.substring(start, start + shortest);
    }

    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        return map;
    }
}
