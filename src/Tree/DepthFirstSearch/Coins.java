package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> builder=new ArrayList<>();
        helper(ans,builder,coins,target,0);
        return ans;
    }

    private void helper(List<List<Integer>> ans,List<Integer>builder,int [] coins,int target,int index){
        //at the last type of coins
        if(index==coins.length-1){
            //have possibility that current solution cannot reach the target(have number left)
            if(target%coins[index]==0){
                int num=target/coins[index];
                builder.add(num);
                //ans.add(builder); builder is changing when backtrack,need to deep copy
                ans.add(new ArrayList<Integer>(builder));
                builder.remove(builder.size()-1);
            }
            return;
        }

        int count=target/coins[index];
        for(int i=count;i>=0;i--){
            builder.add(i);
            int newTarget=target-i*coins[index];
            helper(ans,builder,coins,newTarget,index+1);
            builder.remove(builder.size()-1);
        }
    }
}

