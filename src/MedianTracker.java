import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
You will have to implement the following two methods for the class
read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far
Examples
read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5
......
 */
public class MedianTracker {

    private PriorityQueue<Integer> left;
    private PriorityQueue <Integer> right;
    private Double median;
    public MedianTracker() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    //on average: logn
    public void read(int value) {
        right.add(value);
        balance();
    }

    //O(1)
    public Double median() {
        return median;
    }

    // on average: logn
    private void balance(){
        while(right.size()>=2+left.size()){
            left.offer(right.poll());
        }
        int count = left.size()+right.size();
        if(count%2==0){
            median = (0.0+left.peek()+right.peek())/2;
        }else{
            median = 0.0+right.peek();
        }
    }
}
