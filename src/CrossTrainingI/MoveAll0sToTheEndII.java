package CrossTrainingI;
/*
Given an array of integers, move all the 0s to the right end of the array.
The relative order of the elements in the original array need to be maintained.
Assumptions:
The given array is not null.
Examples:
{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */

public class MoveAll0sToTheEndII {
    public int[] moveZero(int[] array) {
        // clarify: array not null
        // order of the elements need to be maintained
        if(array.length<2){
            return array;
        }
        int slow = 0;
        int fast = 0;
        int count = 0;
        while(fast<array.length){
            if(array[fast]!=0){
                array[slow++] = array [fast++];
            }else{
                fast++;
                count++;
            }
        }
        while(count>0){
            array[array.length-count] = 0;
            count--;
        }
        return array;
    }

}
