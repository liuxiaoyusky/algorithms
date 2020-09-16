import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SortNumbersInTwoStacks {

    //use parameter to lazy implement
    //private static Deque<Integer> stack1=new ArrayDeque<>();//all elements saver
    //private static Deque<Integer> stack2=new ArrayDeque<>();// bottom: sorted elements && top: buffer
    //private static Deque<Integer> stack3=new ArrayDeque<>();//buffer, but can be solved by two stacks

    //sort helper, no need for instance
    public static void sortNumbersInTwoStacks(LinkedList<Integer> array){
        //corner case
        if(array==null||array.size()<=1){
            return;
        }

        LinkedList<Integer> array2=new LinkedList<>();
        sort(array,array2);
    }

    //helper function, Deque is interface, can be implement by LinkedList class
    private static void sort(Deque<Integer> input,Deque<Integer> buffer){
        while(!input.isEmpty()){
            int curMin=Integer.MAX_VALUE;
            int count=0;

            //each time: find min and its count, put all other elements back to input, offer the copy of mins into buffer, didn't deduplicate
            while(!input.isEmpty()){
                int cur=input.pollFirst();
                if(cur<curMin){
                    curMin=cur;
                    count=1;
                }else if(cur==curMin){
                    count++;
                }
                buffer.offerFirst(cur);
            }

            //go through buffer and find all elements before curMin and larger than curMin back to input
            while(!buffer.isEmpty()&&buffer.peekFirst()>=curMin){
                int temp=buffer.pollFirst();
                if(temp!=curMin){
                    input.offerFirst(temp);
                }
            }

            //add duplicated min
            while(count-- >0){
                buffer.offerFirst(curMin);
            }
        }

        //step 2: move result from buffer to input, so it's n descending order
        while(!buffer.isEmpty()){
            input.offerFirst(buffer.pollFirst());
        }
    }

}
