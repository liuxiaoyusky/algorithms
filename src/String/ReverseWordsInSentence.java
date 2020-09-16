package String;

public class ReverseWordsInSentence {
    public String reverseWordsInSentence(String input) {
        if(input==null||input.length()<2){
            return input;
        }

        char [] array=input.toCharArray();
        reverse(array,0,array.length-1);

        int start=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=' '&&(i==0||array[i-1]==' ')){
                start=i;
            }

            if(array[i]!=' '&&(i==array.length-1||array[i+1]==' ')){
                reverse(array,start,i);
            }
        }
        return new String(array);
    }

    private void reverse(char [] array,int start,int end){
        while(start<end){
            swap(array,start,end);
            start++;
            end--;
        }
    }

    private void swap(char [] array,int a,int b){
        char temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
