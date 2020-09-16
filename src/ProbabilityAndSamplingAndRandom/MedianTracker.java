package ProbabilityAndSamplingAndRandom;

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
    private int[] median;
    private boolean odd;
    public MedianTracker(){
        median=new int [2];// median[0] is the median when odd, and mean of median[0] and median[1] when even
        odd=false;
    }
}
