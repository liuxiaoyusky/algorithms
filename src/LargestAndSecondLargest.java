import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
    // The Element class will be used to store the original value in the array and all the values compared to it.
    static class Element{
        int value;
        List<Integer> compredValues;

        Element(int value){
            this.value = value;
            this.compredValues = new ArrayList<>();
        }
    }

    public int[] largestAndSecond (int [] array){
        //Assumption: array is not null, array.length>=2.

        //convert the original array to Element array
        Element [] helper = convert(array);
        //largerLength is the left partition's length containing the larger values after each round of comparison.
        //largerLength is obviously initiated by the array's length.
        int largerLength = array.length;
        //We will terminate when there is only one element left on the larger partition, and it has to be the largest value.
        //The second largest value is the largest value in its compared values.
        while(largerLength>1){
            compareAndSwap(helper,largerLength);
            largerLength = (largerLength+1)/2;//left length always >= right length
        }
        return new int [] {helper[0].value,largest(helper[0].compredValues)};
    }

    private Element[] convert(int[]array){
        Element[] helper = new Element[array.length];
        for(int i=0;i<array.length;i++){
            helper[i] = new Element(array[i]);
        }
        return helper;
    }

    private void compareAndSwap(Element [] array, int n){
        for(int i = 0;i <n/2;i++){
            if(array[i].value<array[n-1-i].value){
                swap(array,i,n-1-i);
            }
            array[i].compredValues.add(array[n-i-1].value);
        }
    }

    private void swap(Element [] array, int a, int b){
        Element temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int largest (List <Integer> list){
        int largest = list.get(0);
        for(int cur:list){
            largest = Math.max(largest,cur);
        }
        return largest;
    }
}
