package FinalExam;

/*#3

How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.

For example

4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
Return 1
10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
Return 2
 */

public class SplitNumIntoMInNumOfSquares {
    //assume positive
    //by dp
    public int findMinItems(int input){
        if(input<4){
            return input;
        }

        //i*2 is the items

        int max=0;
        while(max*max<input){
            max++;
        }

        //ans[0]is the ans,default with all 1s
        int []ans={input};

        findMinHelper(ans, input,0,max-1);
        return ans[0];
    }

    private void findMinHelper(int [] ans, int input,int count,int cur) {
        if (cur == 1) {
            ans[0] = Math.min(ans[0], count + input);
            return;
        }

        int num = input / (cur * cur);
        for (int i = num; i > 0; i--) {
            findMinHelper(ans, input - i * cur * cur, count + i, cur - 1);
            //backtrack
            findMinHelper(ans, input, count, cur - 1);
        }
    }

    public static void main(String []args){
        SplitNumIntoMInNumOfSquares s=new SplitNumIntoMInNumOfSquares();
        System.out.println(s.findMinItems(8));
    }
}
