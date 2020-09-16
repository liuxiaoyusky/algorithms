package ProbabilityAndSamplingAndRandom;

import java.util.ArrayList;
import java.util.List;
/*
Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during
 the processing of the flow, you can return a random set of k elements from the n elements read so far.
Assumptions
k >= 1
You will implement two methods for a sampling class:
read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values
read so fas <= k.
You may need to add more fields for the class.
 */
public class GeneralizedReservoirSampling {
    private final int k;
    private List<Integer> sample;
    private int count;

    public GeneralizedReservoirSampling(int k) {
        // Complete the constructor if necessary.
        this.k = k;
        this.count = 0;
        this.sample = new ArrayList<>();
    }

    public void read(int value) {
        count++;
        if(count<=k){
            sample.add(value);
        }else{
            int index = (int) (Math.random()*count);
            if(index <= k-1){// int will count down!!! 2.9999=>2
                sample.set(index,value);
            }
        }
    }

    public List<Integer> sample() {
        return sample;//should be in time
    }
}
