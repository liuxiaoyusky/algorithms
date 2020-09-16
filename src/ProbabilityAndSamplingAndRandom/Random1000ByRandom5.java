package ProbabilityAndSamplingAndRandom;

import java.util.Random;

public class Random1000ByRandom5 {
    public int random1000() {
        Random random=new Random();

        while(true){
            int num=0;
            for(int i=0;i<5;i++){
                num=num*5+random.nextInt(5);
            }
            if(num<3000){
                return num/3;//or return n%1000
            }
        }
    }
}