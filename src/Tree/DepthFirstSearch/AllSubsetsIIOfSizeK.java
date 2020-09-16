package Tree.DepthFirstSearch;
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.

Assumptions

There could be duplicate characters in the original set.

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
Set = "", K = 0, all the subsets are [""].
Set = "", K = 1, all the subsets are [].
Set = null, K = 0, all the subsets are [].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIOfSizeK {
    //solution2
    public List<String> subSetsIIOfSizeKII(String set, int k){
        List<String> result = new ArrayList<>();
        if(set==null){
            return result;
        }
        char [] arrayset = set.toCharArray();
        Arrays.sort(arrayset);
        StringBuilder sb = new StringBuilder();
        helperII(result,arrayset,sb,0,k);
        return result;
    }

    private void helperII(List <String> result, char [] set, StringBuilder sb, int index, int k){
        if(sb.length()==k){
            result.add(sb.toString());
            return;
        }
        if(index==set.length){
            return;
        }
        //determine if char at set[index] should be included in subset or not
        helperII(result,set,sb.append(set[index]),index+1,k);

        //backtrack
        sb.deleteCharAt(sb.length()-1);
        //skip all consecutive and duplicated elements
        while(index<set.length-1&&set[index]==set[index+1]){
            index++;
        }
        helperII(result,set,sb,index+1,k);
    }


//solution1
    public List<String> subSetsIIOfSizeK(String set, int k) {
        //assume with duplicate letters but dedup answer
        //sort set first, two pointers, slow and fast
        // [0,slow-1] is the answer
        // [fast,] candidates
        // [slow,fast] duplicate subsets, useless in permutation
        List<String> ans = new ArrayList<>();
        if(set==null){
            return ans;
        }
        char [] array = set.toCharArray();
        Arrays.sort(array);
        helper(ans,array,0,0,k);
        return ans;
    }

    private void helper(List<String> ans, char [] array , int slow, int fast, int k){
        if(slow==k){
            ans.add(new String(array,0,k));
            return;
        }
        //choose a letter from array in [fast,], switch it to array[slow], go next
        for(int i = fast;i<array.length;i++){
            swap(array,slow,i);
            helper(ans,array,slow+1,i+1,k);

            //backtrack
            swap(array,slow,i);
            while(i<array.length-1&&array[i]==array[i+1]){
                i++;
            }
        }
    }

    private void swap(char [] array, int a, int b){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}