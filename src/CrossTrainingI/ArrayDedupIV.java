package CrossTrainingI;

import java.util.Arrays;

/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.
Do this in-place, using the left side of the original array. Return the array after deduplication.
Assumptions
The given array is not null
Examples
{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
public class ArrayDedupIV {
    //solution 2: always make slow non-negative, then check array[cur]==array[slow--]
    public int [] dedupII(int [] array){
        int slow = -1;
        for(int i = 0; i<array.length;i++){
            //using left part as a stack, and the top element is slow
            //if the stack is empty(slow==-1), push an element in
            //if the element is not the same as the top element of the stack, push it in as well
            if(slow == -1 || array[slow]!=array[i]){
                array[++slow] = array [i];
            }else{
                while(i+1<array.length && array[i+1]==array[slow]){
                    i++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array,slow+1);
    }

    //solution 1: check the position of slow and array[cur]==array[slow--] at the same time
    public int[] dedup(int[] array) {
        // 祖马
        //assume not null

        if(array.length<2){
            return array;
        }
        int fast = 0;//[fast,] need to check
        int slow = 0;//[0,slow) is the answer
        int cur;//[cur,fast-1] same elements
        while(fast<array.length){
            cur = fast;
            while(fast+1<array.length && array[cur] == array[fast+1]){
                fast++;
            }
            fast++;
            int length = fast-cur;
            if(length == 1){
                if(slow == 0 ||array[cur] != array [slow-1]){
                    array[slow++] = array[cur];
                }else{
                    slow--;
                }
            }else{
                if(slow>0 && array[cur] == array [slow-1]){
                    slow--;
                }
            }
        }
        return Arrays.copyOf(array,slow);
    }
}
