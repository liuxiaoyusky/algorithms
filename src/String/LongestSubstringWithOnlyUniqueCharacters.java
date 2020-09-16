package String;

import java.util.HashSet;
import java.util.Set;
/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string
 is guaranteed to be not null.
For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 */
public class LongestSubstringWithOnlyUniqueCharacters {
    // in worst case, go over the input twice, so time complexity is: O(n), space i: O(1)(extra space besides set is constant)
    public int longest(String input) {
        // two pointers plus hashset. letters in two pointers are the deduped substring
        //clarify: input not null
        //only update max when we hit a duplicated character
        int slow = 0;
        int max = 0;
        Character cur = null;
        Set<Character> set = new HashSet<>();
        for(int fast = 0; fast<input.length(); fast++){
            cur = input.charAt(fast);
            if(!set.contains(cur)){
                set.add(cur);
            }else{
                max = Math.max(max,fast-slow);
                while(input.charAt(slow) != cur){
                    set.remove(input.charAt(slow));
                    slow++;
                }
                slow++;
            }
        }
        return Math.max(max,input.length()-slow);
    }
}
