package String;
/*
Given an array of elements, reorder it as follow:
{ N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
Try to do it in place.
Assumptions
The given array is not null
Examples
{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
{ 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
{ 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 */

public class ReOrderArray {
    //an quick and naive way is split and merge // time O(n) space O(n)
    //here we try to do it in place to save time
    //time complexity:O(nlogn) space:O(1)
    public int[] reorder(int [] array){
        //clarify: array not null, ingore last one if length=odd
        //need to do it in place
        if(array.length<2){
            return array;
        }
        if(array.length%2 == 0){
            reorder(array,0,array.length-1);
        }else{
            reorder(array,0,array.length-2);
        }
        return array;
    }

    private void reorder(int [] array, int left, int right){
        int length = right - left + 1;
        if(length<=2){
            return;
        }

        //split the array evenly into 4 parts, 1234
        int mid = left+length/2;
        int lm = left + length/4;
        int rm = left + length * 3 / 4;

        //switch 23 while keep the inside fixed, totally time complexity O(n/2)
        reverse(array,lm,mid-1);
        reverse(array,mid,rm-1);
        reverse(array,lm,rm-1);

        //now we have 1324, take 13 as a sub problem and 24 a subproblem, still we have a totally time complexity O(n/2)
        //we will do this logn times
        //only two possible situation: n = 2(mod4) or n = 4(mod 4), for the former, we want it to split into 2+4(in such case, take lm-left as a unit)
        reorder(array,left,left+(lm-left)*2-1);
        reorder(array,left+(lm-left)*2,right);
    }
    private void reverse(int [] array, int left, int right){
        while(left<right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
