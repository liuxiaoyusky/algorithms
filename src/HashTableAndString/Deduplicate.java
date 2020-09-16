package HashTableAndString;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deduplicate {
    public String deDup(String input) {
        if(input==null||input.length()<=1){
            return input;
        }
        char[] array=input.toCharArray();
        int prev=0;//[0,prev] are valid
        for(int i=1;i<array.length;i++){
            if(array[prev]==array[i]){
                continue;
            }
            prev++;
            array[prev]=array[i];
        }

        return new String(array,0,prev+1);
    }
    //============================================
    //level 4 祖马: remove adjacent repeated characters IV
    public String deDupIV1(String input){
        if(input==null||input.length()<=1){
            return input;
        }

        Deque<Character> stack=new ArrayDeque<>();
        char [] array=input.toCharArray();
        Character lastRemoved=null;

        //dedup
        for(Character c:array){
            if(stack.isEmpty()){
                if(c==lastRemoved){
                    continue;
                }else{
                    stack.offerFirst(c);
                    lastRemoved=null;
                }
            }else if(c==stack.peek()) {
                lastRemoved=stack.pollFirst();
            }else if(c==lastRemoved) {
                continue;
            }
            else{
                stack.offerFirst(c);
                lastRemoved=null;
            }
        }

        //convert back to the string
        char [] ans=new char[stack.size()];
        while(!stack.isEmpty()){
            ans[stack.size()-1]=stack.pollFirst();
        }

        return new String(ans);
    }

    //==============================================
    //inplace 祖马
    public String deDupIV2(String input){
        if(input==null||input.length()<=1){
            return input;
        }
        char [] array=input.toCharArray();

        //two pointers & use the front of char[] as stack;[0,end] are valid
        int end=0;
        for(int i=1;i<array.length;i++){
            if(end==-1||array[end]!=array[i]){
                end++;
                array[end]=array[i];
            }else{
                end--;
                while(i+1<array.length&&array[i]==array[i+1]){
                    i++;
                }
            }
        }

        return new String(array,0,end+1);
    }

    public static void main(String [] args){
         Deduplicate  deduplicate=new Deduplicate();
         System.out.println(deduplicate.deDupIV1("bacab"));
    }
}
