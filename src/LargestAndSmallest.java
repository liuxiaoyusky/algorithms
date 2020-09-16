/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.
Assumptions
The given array is not null and has length of at least 1
Examples
{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
 */
//Time O(3/2n)
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        // clarify: array not null, length at least one
        int [] ans = new int [2];
        if(array.length ==1){
            ans[0]=array[0];
            ans[1]=array[0];
            return ans;
        }
        int n = array.length;
        for(int i=0; i<n/2;i++){
            if(array[i]<array[n-1-i]){
                swap(array,i,n-1-i);
            }
        }
        //largest in left[0,n/2), smallest in right[n/2,n)
        ans[0] = largest(array,0,n/2);
        ans[1] = smallest (array,n/2,n);

        //corner case
        if(n%2==1){
            int middle = array[n/2];
            ans[0] = Math.max(ans[0],middle);
            ans[1] = Math.min(ans[1],middle);
        }
        return ans;
    }

    private int largest(int [] array, int start, int end){
        int largest = array[start];
        for(int i = start+1;i<end;i++){
            largest = Math.max(largest,array[i]);
        }
        return largest;
    }

    private int smallest(int [] array, int start, int end){
        int smallest = array[start];
        for(int i = start+1;i<end;i++){
            smallest = Math.min(smallest,array[i]);
        }
        return smallest;
    }

    private void swap(int [] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
