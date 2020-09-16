package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

    //consider "doesn't exist" as a branch, add to ans after going to bottom
    public static List<String> allSubsets(String set){
        List <String> ans=new ArrayList<>();

        //corner case
        if(set==null){
            return null;
        }
       char[] arraySet=set.toCharArray();

        //track and record the current subset
        StringBuilder sb=new StringBuilder();

        //start bfs
        subsetHelper(arraySet,sb,0,ans);
        return ans;
    }

    public static void subsetHelper(char[] set,StringBuilder cur, int index,List<String> ans){
        if(index==set.length){
            ans.add(cur.toString());
            return;
        }

        cur.append(set[index]);
        subsetHelper(set,cur,index+1,ans);
        cur.deleteCharAt(cur.length()-1);
        subsetHelper(set,cur,index+1,ans);
    }

    //second way,by dp
    //===================================================
    public static List<String> allSubset2(String string){
        List<String> ans=new ArrayList<>();
        if(string==null||string.length()==0){
            return ans;
        }

        char[] arraySet=string.toCharArray();
        StringBuilder sb=new StringBuilder();

        //run dp
        helper2(ans,sb,0,arraySet);

        return ans;
    }

    private static void helper2(List<String> ans,StringBuilder sb,int index, char[] arraySet){
        ans.add(sb.toString());

        //never looking back,for each current char that i pointing to, with it or without it
        for(int i=index;i<arraySet.length;i++){

            //subset with it
            sb.append(arraySet[i]);
            helper2(ans,sb,i+1,arraySet);

            //subset without it
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        List<String> test=AllSubsets.allSubsets("this");
        System.out.println(test);
        List<String> test2=AllSubsets.allSubset2("123");
        System.out.println(test2);
    }
}
