package CrossTrainingIII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.

Assumptions

    Both arrays are not null.
    There are no duplicate numbers in each of the two arrays respectively.

Exmaples

    A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
    A = {}, B = {3, 1, 4}, return []
 */
public class CommonNumbersOfTwoArraysI {
    //solution 1: find the elements first, then used the quickSort to get ans
    //we can also use pq or Collections.sort() to replace the quickSort
    public List<Integer> common(int[] a, int[] b) {
        //clarify no dup, a  b not null, return in ascending order
        //assume both array in about the same size n
        ArrayList<Integer> result=new ArrayList<>();
        if(a==null||b==null||a.length==0||b.length==0){
            return result;
        }
        //go through a to make a hashset
        Set<Integer> A=new HashSet<>();//add comparator later
        for(int num:a){
            A.add(num);
        }

        //since return in ascending order, need a pq to do it
        for(int commonNum: b){
            if(A.contains(commonNum)){
                result.add(commonNum);
            }
        }
        //Collections.sort(result); //cannot return this, because Collections.sort() return a void
        //return result;

        //corner
        if(result.size()==0){
            return result;
        }

        //silly way
        int [] array=new int [result.size()];
        for(int i=0;i<result.size();i++){
            array[i]=result.get(i);
        }
        quickSort(array,0,array.length-1);

        result.clear();
        for(int n: array){
            result.add(n);
        }

        return result;
    }

    public int [] quickSort(int [] array) {
        //corner case
        if (array == null) {
            return array;
        }

        quickSort(array,0,array.length - 1);
        return array;
    }

    private void quickSort(int [] array, int left, int right) {
        if (left >= right) {
            return;
        }

        //define a pivot and use the pivot to partition the array
        int pivotPosition = partition(array, left, right);
        // pivot is already at its position, when we do the recursive call on the two partitions,
        // pivot should not be included in any of them
        quickSort(array, left, pivotPosition - 1);
        quickSort(array, pivotPosition + 1, right);
    }

    //[left, right] is the pivot range
    //[left,leftBound) : <pivot value
    //(rightBound,right-1]: >=pivot value
    private int partition(int [] array, int left, int right) {
        int pivotIndex = pivotIndex(left,right);
        int pivotValue = array[pivotIndex];
        //swap the pivot element to the rightmost position first
        swap(array,pivotIndex, right);
        //go through the rest elements, leftBound and rightBound is next index to check
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivotValue) {
                leftBound++;
            }else if (array[rightBound] >= pivotValue) {
                rightBound--;
            } else {
                swap(array, rightBound++, rightBound--);
            }
        }
        //swap back the pivot element,since we put pivot at right most, we need to sway with leftBound
        swap(array,leftBound,right);
        //return the final position of pivot element, which is leftBound
        return leftBound;
    }

    private int pivotIndex(int left,int right){
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int []array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
