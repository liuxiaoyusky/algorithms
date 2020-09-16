package Tree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 */
public class AllValidPermutationsOfParenthesesII {
    public List<String> validParenthesesII(int l, int m, int n) {
        //do it by dfs
        //assume not negative numbers
        //left can be added freely
        //right can be added when:
        //1:right<left and 2: same kind with last left
        List<String> ans=new ArrayList<>();
        Deque<Integer> stack=new LinkedList<>();
        int length=l*2+n*2+m*2;
        int [] pairs=new int []{l,l,m,m,n,n};
        char [] pairsCh=new char[]{'(',')','<','>','{','}'};
        StringBuilder sb=new StringBuilder();
        validParenthesesHelper(ans,sb,length,pairs,pairsCh,stack);
        return ans;
    }

    private void validParenthesesHelper(List<String> ans, StringBuilder sb, int length,int [] pairs,char [] pairsCh,Deque<Integer> stack){
        //all done
        if(sb.length()==length){
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<pairs.length;i++){
            //add left freely
            if(i%2==0){
                if(pairs[i]>0){
                    sb.append(pairsCh[i]);
                    stack.offerFirst(i);
                    pairs[i]--;
                    validParenthesesHelper(ans,sb,length,pairs,pairsCh,stack);

                    //backtrack
                    sb.deleteCharAt(sb.length()-1);
                    stack.pollFirst();
                    pairs[i]++;
                }
            }else{
                //pairs[i]<pairs[i-1] is not neccessary when using stack, since the only option is when the first of stack is the same kind of parentheses
                if(!stack.isEmpty()&&stack.peekFirst()==i-1){
                    sb.append(pairsCh[i]);
                    stack.pollFirst();
                    pairs[i]--;
                    validParenthesesHelper(ans,sb,length,pairs,pairsCh,stack);

                    //backtrack
                    sb.deleteCharAt(sb.length()-1);
                    stack.offerFirst(i-1);
                    pairs[i]++;
                }
            }
        }
    }
}
