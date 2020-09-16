package FinalExam;

/*
#4

Given an array of strings, find if all the strings can be chained to form a circle. Two string s1 and s2 can be chained, iff the last letter of s1 is identical to the first letter of s2.

 For example,

“abc” and “cd” can be chained,

“abc” and “dz” can not be chained.

 Example Input:

arr[] = {"aaa", "bbb", "baa", "aab"};

Output: True,

The given input strings can be chained to form a circle. The strings can be chained as "aaa", "aab", "bbb" and "baa"
 */

import java.util.ArrayList;
import java.util.List;

public class CheckStringIsChainable {
    //input String[]
    //output boolean
    //assume empty list and single String are chainable
    public boolean checkStringChainable(String[] input){
        if(input==null||input.length==0){
            return true;
        }

        //corner case: when only one string
        else if(input.length==1){
            return chainable(input[0],input[0]);
        }

        //since we want a circle, we can always skip the first string
        return chainableHelper(input, 1);
    }

    private boolean chainableHelper(String [] array, int index){
        //base case when index==array.length
        if(index==array.length){
            return chainable(array[array.length-1],array[0]);
    }

        boolean globalResult=false;
        for(int i=index;i<array.length;i++){
            //not first letter, check chainable
            if(chainable(array[index-1],array[i])){
                swap(array,index,i);
                globalResult=globalResult||chainableHelper(array,index+1);
                //backtrack
                swap(array,index,i);
                globalResult=globalResult||chainableHelper(array,index+1);
            }
        }
        return globalResult;
    }

    private boolean chainable(String tail, String head){
        return tail.charAt(tail.length()-1)==head.charAt(0);
    }

//    private String [] toArray(List<String> input){
//        String [] array=new String[input.size()];
//        int i=0;
//        for(String st: input){
//            array[i]=st;
//            i++;
//        }
//        return array;
//    }
    private void swap(String [] array, int a, int b){
        String temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    public static void main(String [] args){
        CheckStringIsChainable c=new CheckStringIsChainable();
        String [] array={"daa","aab","bac","caa","ad","dddd"};
        System.out.println(c.checkStringChainable(array));

    }
}
