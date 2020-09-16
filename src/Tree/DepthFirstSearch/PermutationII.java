package Tree.DepthFirstSearch;

import java.util.*;

public class PermutationII {
    public List<String> permutations(String set) {
        //cla,assume
        List<String> ans=new ArrayList<String>();
        if(set==null){
            return ans;
        }else if(set.length()==0){
            ans.add("");
            return ans;
        }

        char[] array=set.toCharArray();
        StringBuilder sb=new StringBuilder();

        boolean [] used=new boolean[array.length];
        helper(used,ans,sb,array);

        return ans;
    }
    private void helper(boolean [] used,List<String> ans, StringBuilder sb, char [] array){
        if(sb.length()==array.length){
            ans.add(new String(sb));
            return;
        }

        Set<Character> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            if(!used[i]&&!set.contains(array[i])){
                sb.append(array[i]);
                set.add(array[i]);
                used[i]=true;
                helper(used,ans,sb,array);
                //backtrack
                used[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String [] args){
        PermutationII permutationII=new PermutationII();
        System.out.println(permutationII.permutations("adbacb"));
    }
}
