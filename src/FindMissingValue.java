import java.util.HashSet;

public class FindMissingValue {
    //hashSet
    public int missingI(int[]array){
        int n=array.length+1;
        HashSet<Integer> set=new HashSet<>();
        for(int number:array){
            set.add(number);
        }
        for(int i=1;i<=array.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n;
    }

    //difference of sum
    public int missingII(int[] array){
        int n=array.length+1;
        long targetSum=(n+0L)*(n+1)/2;//L means long, otherwise, a number means integer by default
        long actual=0l;
        for(int num:array){
            actual+=num;
        }
        return (int) (targetSum-actual);
    }

    //bit operation-O(n)
    public int missingIII(int [] array){
        int n=array.length+1;
        int xor=0;
        //xor 1 to n
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        for(int num:array){
            xor^=num;
        }
        return xor;
    }

    //swap to the original position
    public int missingIV(int [] array){
        int n=array.length+1;
        for(int i=0;i<array.length;i++){
            //current num is not in correct position and has a right positon
            while(array[i]!=n&&array[i]!=i+1){
                swap(array,i,array[i]-1);
            }
        }

        for(int i=0;i<array.length;i++){
            if(array[i]!=i+1){
                return i+1;
            }
        }

        return n;
    }

    private void swap(int [] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    public static void main(String[]args){
        FindMissingValue findMissingValue=new FindMissingValue();
        int[] array={3,6,5,1,2};
        System.out.println(findMissingValue.missingI(array));
        System.out.println(findMissingValue.missingII(array));
        System.out.println(findMissingValue.missingIII(array));
        System.out.println(findMissingValue.missingIV(array));

    }
}
