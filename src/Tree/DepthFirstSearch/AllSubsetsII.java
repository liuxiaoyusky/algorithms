package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that
 each subset returned will be sorted to remove the sequence.
 */


public class AllSubsetsII {
    public List<String> subSets(String set) {
        // result is dedup and sorted
        // can sort first and then do as what inclass shows
        List<String> ans=new ArrayList<>();
        if(set==null){
            return ans;
        }

        char []array=set.toCharArray();
        Arrays.sort(array);

        StringBuilder sb=new StringBuilder();

        helper(ans,array,sb, 0);
        return ans;
    }

    private void helper(List<String> ans, char[] array, StringBuilder sb,int index){
        if(index==array.length){
            ans.add(sb.toString());
            return;
        }

        sb.append(array[index]);
        helper(ans,array,sb,index+1);

        //backtrack and dedup
        sb.deleteCharAt(sb.length()-1);
        while(index<array.length-1&&array[index]==array[index+1]){
            index++;
        }
        helper(ans,array,sb,index+1);
    }
}
