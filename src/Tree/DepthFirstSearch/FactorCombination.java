package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
 */

public class FactorCombination {
    public List<List<Integer>> combinations(int target) {
        // assume>=2, factor 1 is not included
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curFactors = new ArrayList<>();
        List<Integer> list = findFactors(target);
        helper(target,ans,curFactors,list,0);
        return ans;
    }

    private void helper(int target, List<List<Integer>> ans,List<Integer> factors,
                        List<Integer> list,int index){
        if(target==1){
            ans.add(new ArrayList<>(factors));
            return;
        }

        for(int i=index;i<list.size();i++){
            int cur=list.get(i);
            if(cur<=target&&target%cur==0){
                factors.add(cur);
                helper(target/cur,ans,factors,list,i);

                //backtrack
                factors.remove(factors.size()-1);
            }
        }

        // //add target itself to factors if factors is not empty
        // if(!factors.isEmpty()){
        //   factors.add(target);
        //   helper(1,ans,factors);
        //   factors.remove(factors.size()-1);
        // }

    }

    private List<Integer> findFactors(int target){
        List<Integer> allFactors = new ArrayList<>();
        for(int i =target/2;i>=2;i--){
            if(target%i==0){
                allFactors.add(i);
            }
        }
        return allFactors;
    }

    public static void main(String []args){
        FactorCombination factorCombination=new FactorCombination();
        System.out.println(factorCombination.combinations(1024));
    }
}
