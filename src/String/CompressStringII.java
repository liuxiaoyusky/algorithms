package String;

/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
Assumptions
The string is not null
The characters used in the original string are guaranteed to be ‘a’ - ‘z’
Examples
“abbcccdeee” → “a1b2c3d1e3”
 */

public class CompressStringII {
//solution 3: StringBuilder: naive way, skip

//time: O(n) go over twice:2n
//space: O(n or 1) if consider the ans and array are part of the answer, then space is O(1), otherwise O(n)
//solution 2: all situations are possible. never exist digits, only 'a' to 'z'. go over twice: compress all letters first, expand one letter secondly
    public String compress2(String input){
        //assume not null
        int newlen = 0;
        char [] array = input.toCharArray();
        int fast = 0;
        int slow = 0;
        int cur = 0;
        //first round
        while(fast<array.length){
            cur = fast;
            //find and skip all consecutive letters
            while(fast+1<array.length && array[fast]==array[fast+1]){
                fast++;
            }
            fast++;

            //if count == 1, copy cur to slow, don't add 1, go next; else, compress letters
            int count = fast-cur;
            if(count == 1){
                array[slow++]=array[cur];
                newlen+=2;
            }
            else{
                array[slow] = array[cur];
                slow++;
                int len = compressHelper(array,slow,count);
                slow+= len;
                newlen +=len+1;
            }
        }

        //second round
        char [] ans = new char [newlen];
        fast = ans.length-1;
        slow = slow-1;
        while(fast>=0){
            //digits
            if(Character.isDigit(array[slow])){
                //copy all digits
                while(fast>=0 && Character.isDigit(array[slow])){
                    ans[fast] = array[slow];
                    fast--;
                    slow--;
                }
            }else{
                ans[fast] = '1';
                fast--;
            }

            //one character ans[fast--] = array [slow--];
            ans[fast] = array[slow];
            fast--;
            slow--;
        }

        return new String(ans,0,newlen);
    }

//solution 1: assume very high frequency, dozens of repeated letters, no unique, in place, space big enough
    public String compress(String input) {
        // clarify: string not null
        char [] array = input.toCharArray();
        int fast = 0;//[fast,input.length-1] need to check
        int slow = 0;//[0,slow-1] answer
        int cur = fast;//cur is the start of current repeated letter
        while(fast<array.length){
            cur = fast;

            while(fast+1<array.length && array[fast] == array[fast+1]){
                fast++;
            }
            fast++;

            array[slow] = array[cur];
            slow++;
            slow+=compressHelper(array,slow,fast - cur);
        }
        return new String(array,0,slow);
    }

    private int compressHelper(char [] array, int slow, int count){
        int index = 0;
        int i = count;
        while(i != 0){
            i/=10;
            index++;
        }
        int temp = index;
        while(temp>0){
            int restNum = count % 10;
            array[slow-1+temp] = (char)('0'+ restNum);
            count /= 10;
            temp--;
        }
        return index;
    }
    public static void main(String [] args){
        CompressStringII compressStringII = new CompressStringII();
        System.out.println(compressStringII.compress2("aaabc"));
    }
}
