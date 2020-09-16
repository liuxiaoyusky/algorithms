package ProbabilityAndSamplingAndRandom;


public class ReservoirSampling {
    private int count;
    private Integer sampleNum;
    public ReservoirSampling() {
        this.count=0;
        this.sampleNum=null;

    }

    public void read(int value) {
        count++;
        int pro=(int) (Math.random()*count);
        if(pro==0){
            sampleNum=value;
        }
    }

    public Integer sample() {
        return sampleNum;
    }
}
