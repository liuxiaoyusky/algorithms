package HashTableAndString;

import java.util.ArrayList;
import java.util.List;

public class StringReplacement {
    public String stringReplacement(String input, String source, String target) {
        if(input==null||input.length()<source.length()){
            return input;
        }
        char [] array=input.toCharArray();
        if(source.length()>=target.length()){
            return replaceShort(array,source,target);
        }else{
            return replaceLonger(array,source,target);
        }
    }

    private String replaceShort(char [] array,String source, String target){
        int slow=0;
        int fast=0;
        while(fast<array.length){
            if(array.length-fast>=source.length()&&match(array,fast,source)){
                replace(array,slow,target);
                slow+=target.length();
                fast+=source.length();
            }else{
                array[slow++]=array[fast++];
            }
        }
        return new String(array,0,slow);
    }

    private String replaceLonger(char [] array, String source, String target){
        //we will need a longer array
        //if we need to do this inplace, we will assume this is long enough and input is part of it that start from index 0
        //we want the number of replacement and position of them
        List<Integer> matches=getAllMatches(array,source);
        char [] result=new char [array.length+matches.size()*(target.length()-source.length())];
        int fast=array.length-1;
        int slow=result.length-1;
        int lastMatches=matches.size()-1;
        while(fast>=0){
            if(lastMatches>=0&&fast==matches.get(lastMatches)){
                //think about replace 3 with 3
                replace(result,slow+1-target.length(),target);
                slow-=target.length();
                fast-=source.length();
                lastMatches--;
            }else{
                result[slow--]=array[fast--];
            }
        }
        return new String(result);
    }

    private List<Integer> getAllMatches(char [] array, String source){
        List<Integer> matches=new ArrayList<>();
        for(int i=0;i<=array.length-source.length();i++){
            if(match(array,i,source)){
                //if get confused, think about a 3-3 example
                matches.add(i+source.length()-1);
                i+=source.length()-1;
            }
        }
        return matches;
    }

    private boolean match(char [] array, int fast, String source){
        for(int i=0;i<source.length();i++){
            if(array[fast+i]!=source.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private void replace(char [] array, int slow,String target){
        for(int i=0;i<target.length();i++){
            array[slow+i]=target.charAt(i);
        }
    }
    //------------------------------------------------------------------------
    //solution two
    public String replaceII(String input,String source,String target){
        //assume input, source and target are not null and source is not empty
        StringBuilder sb=new StringBuilder();
        int fromIndex=0;
        //check if there exists a sbustring same as source in input after index x, x=fromIndex,return -1 if not found
        int matchIndex=input.indexOf(source,fromIndex);
        while(matchIndex!=-1){
            //add the substring of input from fromIndex to matchIndex(not included), then append target
            sb.append(input,fromIndex,matchIndex).append(target);
            //next time we need to start from matchIndex+s.length()
            fromIndex=matchIndex+ source.length();
            matchIndex=input.indexOf(source,fromIndex);
        }
        sb.append(input,fromIndex,input.length());
        return sb.toString();

    }
    public static void main(String[] args){
        StringReplacement stringReplacement=new StringReplacement();
        System.out.println(stringReplacement.stringReplacement("applecatapp","app","pear"));
    }
}

