package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class AllValidParenthesesPairs {
    public static List<String> allvalidParenthesesPairs(int n){
        List<String> parenthesesPairs=new ArrayList<>();
        if(n<0){
            return parenthesesPairs;
        }

        char[] pairSet=new char[n*2];
        helper(pairSet,n,n,0,parenthesesPairs);
        return parenthesesPairs;
    }

    private static void helper(char[]pairSet,int left,int right,int index,List<String> result){
        if(left==0&&right==0){
            //result.add(pairSet.toString()); not workable, will return a reference
            result.add(new String(pairSet));

            return;
        }
        if(left>0){
            pairSet[index]='(';
            helper(pairSet,left-1,right,index+1,result);
        }
        if(right>left){
            //replace the char that index pointing to from left parenthesis to right parenthesis
            pairSet[index]=')';
            helper(pairSet,left,right-1,index+1,result);
        }
    }




    ///--------
    public static List<String> ifBlocks(int n){
        List<String>ans=new ArrayList<>();
        if(n<0){
            return ans;
        }

        List<String>cur=new ArrayList<>();
        helper2(ans,cur,n,n);
        return ans;
    }

    private static void helper2(List<String> ans,List<String>cur,int left, int right){
        if(left==0&&right==0){
            String solution="";
            for(int i=0;i<cur.size();i++){
                solution=solution+cur.get(i)+"\n";
            }
            ans.add(solution);
            ans.add("\n");
            return;
        }

        if(left>0){
            cur.add("if{");
            helper2(ans,cur,left-1,right);
            cur.remove(cur.size()-1);
        }
        if(right>left){
            cur.add("}");
            helper2(ans,cur,left,right-1);
            cur.remove(cur.size()-1);
        }

    }

    public static void main(String [] args){
        List<String> test=AllValidParenthesesPairs.ifBlocks(2);
        System.out.println(test);
    }
}
