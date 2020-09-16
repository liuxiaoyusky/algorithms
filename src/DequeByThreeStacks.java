import java.util.ArrayDeque;
import java.util.Random;

public class DequeByThreeStacks {
    private ArrayDeque<Integer> front;
    private ArrayDeque<Integer> buffer;
    private ArrayDeque<Integer> back;

    //missing constructor!!!!!!!!!!!!!!!!
    public DequeByThreeStacks(){
        front=new ArrayDeque<>();
        buffer=new ArrayDeque<>();
        back=new ArrayDeque<>();
    }

    public void offerFirst(int num){
        front.offerFirst(num);
    }

    public void offerLast(int num){
        back.offerFirst(num);
    }

    public Integer pollFirst(){
        move(back,front);
        return front.isEmpty()? null:front.pollFirst();
    }

    public Integer pollLast(){
        move(front, back);
        return back.isEmpty()? null:back.pollFirst();
    }

    public Integer peekFirst(){
        move(back,front);
        return front.isEmpty()? null: front.peekFirst();
    }

    public Integer peekLast(){
        move(front,back);
        return back.isEmpty()? null: back.peekFirst();
    }

    public boolean isEmpty(){
        return front.isEmpty()&&back.isEmpty();
    }

    public int size(){
        return front.size()+back.size();
    }

    private void move(ArrayDeque<Integer> scr,ArrayDeque<Integer> des){
        if(!des.isEmpty()){
            return;
        }

        //corner case: only 1 in scr
        int num=scr.size()/2;

        //put the first half into buffer, put the rest have into des, move first half back to scr from buffer at the end
        for(int i=0;i<num;i++){
            buffer.offerFirst(scr.pollFirst());
        }

        while(!scr.isEmpty()){
            des.offerFirst(scr.pollFirst());
        }

        while(!buffer.isEmpty()){
            scr.offerFirst(buffer.pollFirst());
        }
    }


}
