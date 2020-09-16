package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static List<String> permutations(String set) {
        List<String> ans=new ArrayList<>();

        //wrong solution for corner case
        // if(set==null&&set.length()==0){
        //   return ans;
        // }

        if(set==null&&set.length()==0){
            ans.add("");
            return ans;
        }

        char[]letterSet=set.toCharArray();
        StringBuilder sb=new StringBuilder();

        helper(letterSet,sb,ans,0);
        return ans;
    }

    private static void helper(char[]letterSet, StringBuilder sb, List<String> ans, int index){
        if(index==letterSet.length-1){
            ans.add(new String(letterSet));
            return;
        }

        for(int i=index;i<letterSet.length;i++){
            swap(letterSet,index,i);
            helper(letterSet,sb,ans,index+1);
            swap(letterSet,index,i);
        }
    }

    private static void swap(char[] array, int first, int second){
        char temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }

    //--------------------------------------------------------------------------------------------------
    //solution two:purmutation without changing order, use a boolean[] instead of int to track
    public static List<String> permutationWithOrder(String set){
        List<String> ans=new ArrayList<>();
        if(set==null){
            ans.add("");
            return ans;
        }

        char []letters=set.toCharArray();

        //sort by build-in method
        Arrays.sort(letters);

        boolean[] used=new boolean[letters.length];
        StringBuilder sb=new StringBuilder();
        helper2(letters,used,ans,sb);

        return ans;
    }

    private static void helper2(char[]letters,boolean[]used,List<String> ans,StringBuilder sb){
        if(sb.length()==letters.length){
            ans.add(new String(sb));
        }

        for(int i=0;i<letters.length;i++){
            if(used[i]==false){
                sb.append(letters[i]);
                used[i]=true;
                helper2(letters,used,ans,sb);

                //backtrack
                sb.deleteCharAt(sb.length()-1);
                used[i]=false;
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------
    public static void main(String[]args){
        System.out.println(permutationWithOrder("abc"));
    }
}
