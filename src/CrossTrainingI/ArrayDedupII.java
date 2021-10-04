package CrossTrainingI;

import java.util.Arrays;

/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two
 of them. Do this in-place,
using the left side of the original array and maintain the relative order of the elements of the array. Return the array
after deduplication.
Assumptions
The given array is not null
Examples
{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 */

public class ArrayDedupII {

//solution 2: a more tricky way
    public int [] dedupII(int [] array){
        if(array.length<=2){
            return array;
        }
        int end = 1;
        for(int i=2;i<array.length;i++){
            //a sliding window of 3 cells
            //this is sorted, so
            //array[i] == array[end-1] implies that array[end-1] == array[end]==array[i]
            if(array[i] != array [end-1]){
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array,end+1);
    }
//solution 1: a direct way
    public int[] dedup(int[] array) {
        // clarify: sorted, keep same elements at most two of them, in place
        int slow=0;//[0,slow-1] answer
        int fast=0;//[fast,] need to check
        int start=0;//[start, fast] same elements

        while(fast<array.length){
            start = fast;
            while(fast+1<array.length && array[start]==array[fast+1]){
                fast++;
            }
            fast++;

            array[slow++]=array[start];
            if(fast-start>1){
                array[slow++]=array[start];
            }
        }
        return Arrays.copyOf(array,slow);
    }

    private String printArray(int [] array){
        StringBuilder sb = new StringBuilder();
        for(int cur : array){
            sb.append(cur+" ");
        }
        return sb.toString();
    }

    public static void main(String [] args){
        ArrayDedupII arrayDedupII = new ArrayDedupII();
        int [] array = new int []{1,1,1,1,2,2,3,4,5,5,5,5,5};
        System.out.println(arrayDedupII.printArray(arrayDedupII.dedupII(array)));
    }
}
