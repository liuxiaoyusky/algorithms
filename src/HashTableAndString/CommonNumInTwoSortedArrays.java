package HashTableAndString;

import java.util.*;
//input two int array, output List<Integer>
//sorted in ascending order, with dup
//both array not null
//if one array is extremely shorter than the other, assume A is the shorter one, binary search A in B;
//if two arrays are about the same length, two pointer.
public class CommonNumInTwoSortedArrays {
    //space: O(m) Time:O(m+n) A.length = m, B.length = n
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> ans=new ArrayList<>();
        //assume A and B are not null
        HashMap<Integer,Integer> map=new HashMap<>();//<key,value>pair
        for(int a:A){
            Integer temp=map.get(a);
            if(temp==null){
                map.put(a,1);
            }else{
                map.put(a,temp+1);
            }
        }
        for(int b:B){
            Integer count=map.get(b);
            if(count!=null){
                if(count>0){
                    ans.add(b);
                    map.put(b,count-1);
                }
            }
        }
        return ans;
    }

    //-------------------------------------------------------------------------
    //solution: two by two pointers
    //space: O(1) Time:O(m+n) A.length = m, B.length = n
    public List<Integer> common2(int [] A,int [] B){
        List<Integer> ans=new ArrayList<>();
        int a=0;
        int b=0;
        //int length=Math.min(A.length,B.length);
        while(a<A.length && b<B.length){
            if (A[a] < B[b]) {
                a++;
            } else if (A[a] > B[b]) {
                b++;
            }
            else {
                ans.add(A[a]);
                a++;
                b++;
            }
        }
        return ans;
    }

    //-----------------------------------------------------------------------------------
    //solution: binary search when one is extremely shorter (A is shorter), and B doesn't have too much dup
    //A.length = m; B.length = n.
    //Time:O(mlogn on average, if dup in B is too much, this could be mn when finding left most target in B)
    //Space:O(1)
    public List<Integer> common3(int[] A, int[] B) {
        List <Integer> ans = new ArrayList<>();
        //corner case: check empty
        if(A.length == 0 || B.length == 0) {
            return ans;
        }

        //search each element of A in B start from the left Bound
        int leftBound = 0;
        for (int a : A) {
            leftBound = binarySearch(B,a,leftBound,ans);
        }
        return ans;
    }

    //binary search a in B
    //1. if find, return the leftmost index + 1, add the number to ans;
    //2. if not: return the index of B that is the first element larger than a.
    private int binarySearch(int[] B, int a, int leftBound, List<Integer> ans) {
        //corner case: when B is extremely large, the next check on a could out of bound
        if (leftBound >= B.length) {
            return leftBound;
        }

        //corner case: check if the left most b is larger than or equal to a
        if (B[leftBound] == a) {
            ans.add(a);
            return leftBound+1;
        } else if (B[leftBound] > a) {
            return leftBound;
        }

        //target in range, binary search it
        int left = leftBound;
        int right = B.length-1;
        int mid = left + (right - left)/2;

        //stop when one element left
        while (left < right) {
            mid = left + (right - left)/2;
            //check mid
            if (B[mid] < a) {
                left = mid + 1;
            } else if (B[mid] > a) {
                right = mid - 1;
            } else {
                //find the target, now find the left most target
                while (mid != 0) {
                    if (B[mid] == B[mid-1]) {
                        mid--;
                    } else {
                        ans.add(a);
                        return mid + 1;
                    }
                }
            }
        }
        if (B[left] == a) {
            ans.add(a);
            return left + 1;
        } else if (B[left] > a) {
            return left;
        } else {
            return left + 1;
        }
    }
}
