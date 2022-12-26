package SlidingWindows;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
given a string s and an integer k, return the length of the longest substring of s
that contains at most k distinct characters.
 */
public class LongestSubstringWithKMostDistinctChars {
    public int longest(String s, int k) {
        if (s == null) {
            return 0;
        }
        int slow = 0;
        int result = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //move right
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            //move left
            while (map.size() > k) {
                cur = s.charAt(slow);
                Integer count = map.get(cur);
                if (count == 1) map.remove(cur);
                else map.put(cur, count - 1);
                slow++;
            }

            //update global
            result = Math.max(result, i - slow + 1);
        }

        return result;
    }
//solution 2: use hashmap to count distinct and track, use treeset to find most recent
    class Element implements Comparable<Element>{
        int mostRecentIndex;
        char value;
        public Element(int m, char v) {
            this.mostRecentIndex = m;
            this.value = v;
        }

        public int compareTo(Element o) {
            if (this.mostRecentIndex == o.mostRecentIndex) {
                return 0;
            }

            return this.mostRecentIndex > o.mostRecentIndex ? -1 : 1;
        }
    }
    public int longestII(String s, int k) {
        if (s == null) {
            return 0;
        }
        int result = -1;
        int slow = -1;

        //use a treeset maintain the most resent used, the last is the least used and should be popped
        TreeSet<Element> elements = new TreeSet<>();
        HashMap<Character, Element> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            //step 1: add or update
            Element e = map.get(cur);
            if (e == null) {
                e = new Element(i, cur);
                elements.add(e);
                map.put(cur, e);
            } else {
                elements.remove(e);
                e.mostRecentIndex = i;
                elements.add(e);
            }

            //step 2: check and update left
            if (map.size() > k) {
                Element left = elements.last();
                slow = left.mostRecentIndex;
                char c = left.value;

                elements.remove(left);
                map.remove(c);
            }

            //step 3: update result
            result = Math.max(result, i - slow);
        }
        return result;
    }

}
