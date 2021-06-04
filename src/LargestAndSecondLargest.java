import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
    //the idea is that we saved the compared value with the original number, because the 2nd largest number has to be in
    //the compared list of the largest number.

    //we then find the largest by a quick sort like search.
    public int[] largestAndSecond (int [] array){
        //by given assumption, we know array is not null, and array.length >=2
        //assume no dup

        //convert from int to element
        Element [] newArray = convert(array);


        //find the largest element in [0, serachingSpace)
        int searchingSpace = array.length;


        //keep larger element on right half
        while(searchingSpace >= 2) {
            int left = 0;
            int right = searchingSpace - 1;
            while(left < right) {
                if (newArray[left].value > newArray[right].value) {
                    newArray[left].comparedList.add(newArray[right].value);
                } else {
                    swap(newArray,left, right);
                    newArray[left].comparedList.add(newArray[right].value);
                }
                left++;
                right--;
            }
            searchingSpace = (searchingSpace + 1) / 2 ;
        }

        Element largest = newArray[0];

        return new int[] {largest.value, findLargest(largest.comparedList)};
    }

    private int findLargest(List <Integer> list) {
        int largest = list.get(0);
        for (int cur: list) {
            largest = Math.max(cur,largest);
        }
        return largest;
    }

    private void swap(Element [] array, int a, int b) {
        Element temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private Element[] convert(int [] array) {
        Element [] arr = new Element [array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = new Element(array[i]);
        }
        return arr;
    }

    static class Element {
        int value;
        List <Integer> comparedList;

        public Element(int value){
            this.value = value;
            comparedList = new ArrayList<>();
        }
    }
}
