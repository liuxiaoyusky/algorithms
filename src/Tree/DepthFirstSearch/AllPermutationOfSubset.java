package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfSubset {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> ans=new ArrayList<>();
        if(set==null){
            return ans;
        }

        char [] array=set.toCharArray();
        helper(array,ans,0);

        return ans;
    }
    //choose the character to be at the position of "index"
    //all the already chosen positions are (0,index-1)
    //all the candidate characters can be at position "index"
    //are in the subarray of(index,length-1)
    private void helper(char [] array, List<String> ans, int index){
        //[0,index-1]are one subset,
        // array[index] is swtichable with char in [index,array.length-1]
        //record subset at the begining and switch back for back track
        ans.add(new String(array,0,index));

        for(int i=index;i<array.length;i++){
            swap(array,i,index);
            helper(array,ans,index+1);

            //backtrack
            swap(array,i,index);
        }
    }

    private void swap(char [] array, int a, int b){
        char temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    public static void main(String [] args){
        AllPermutationOfSubset allPermutationOfSubset=new AllPermutationOfSubset();
        System.out.println(allPermutationOfSubset.allPermutationsOfSubsets("abc"));
    }
}
