package String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
Assumptions
s is not null or empty.
l is not null.
Examples
l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */

public class AllAnagrams {
    //instead of track letters and their numbers, a easier way is track only the letters by recording the number of letters
    //when their number reach one;
    //eg: when check the new letter, count+1 when we find map.get(charAt())==1;
    // when delete a former letter, count -1 when we find map.get(charAt())==0.
    //time: O(M+N) (length of sh and lo)    space:O(M) length of sh
    public List<Integer> allAnagrams(String sh, String lo) {
        //clarify: lo,sh not null; sh not empty
        //hashset
        List<Integer> ans = new ArrayList<>();
        if(lo.length()==0){
            return ans;
        }
        HashMap<Character,Integer> map = hashMap(sh);

        int count = 0;

        Integer cur = 0;
        Character temp = null;
        //initialize
        for(int i = 0; i<sh.length(); i++){
            cur = map.get(lo.charAt(i));
            if(cur!=null){
                if(cur>0){
                    count++;
                }
                map.put(lo.charAt(i),cur-1);
            }
        }
        if(count == sh.length()){
            ans.add(0);
        }

        //delete char at i-1 and add char at i+sh.length()-1
        for(int i =1; i<=lo.length()-sh.length(); i++){
            //delete
            temp = lo.charAt(i-1);
            cur = map.get(temp);
            if(cur != null){
                if(cur >= 0){
                    count--;
                }
                map.put(temp,cur+1);
            }
            //add
            temp = lo.charAt(i+sh.length()-1);
            cur = map.get(temp);
            if(cur != null){
                if(cur > 0){
                    count++;
                }
                map.put(temp,cur-1);
            }
            //check
            if(count == sh.length()){
                ans.add(i);
            }
        }
        return ans;
    }

    private HashMap<Character,Integer> hashMap(String input){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i<input.length();i++){
            Integer cur = map.get(input.charAt(i));
            if(cur == null){
                map.put(input.charAt(i),1);
            }else{
                map.put(input.charAt(i),cur+1);
            }
        }
        return map;
    }


}
