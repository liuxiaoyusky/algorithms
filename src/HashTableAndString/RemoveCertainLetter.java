package HashTableAndString;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainLetter {
    public String remove(String input, String t) {
        if(input==null&&t==null){
            return input;
        }

        char[] array=input.toCharArray();
        Set<Character> set=new HashSet<>();

        //take too mach space
        // char[] element=t.toCharArray();
        // for(char e:element){
        //   set.add(e);
        // }

        for(int i=0;i<t.length();i++){
            set.add(t.charAt(i));
        }


        int fast=0;
        int slow=0;//[0,slow) will be returned
        while(fast<array.length){
            if(set.contains(array[fast])){
                fast++;
            }else{
                array[slow]=array[fast];
                //swap(array,fast,slow);
                fast++;
                slow++;
            }
        }
        return new String(array,0,slow);
    }

//    private void swap(char[]array,int a,int b){
//        char temp=array[a];
//        array[a]=array[b];
//        array[b]=temp;
//    }
}
