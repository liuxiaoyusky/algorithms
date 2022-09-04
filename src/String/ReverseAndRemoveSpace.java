package String;

public class ReverseAndRemoveSpace {
    public static String reverseWords(String s) {
        // corner case
        if(s == null || s.length() < 2)
        {
            return s;
        }

        String k = trimSpaces(s);

        char[] array = k.toCharArray();
        // int start = 0;
        // int end = array.length - 1;
        // reverse(array, start, end);

        // for(int i = 0; i <= array.length - 1; i++)
        // {
        //   if(array[i] != ' ' &&(i == 0 || array[i-1] == ' '))
        //   {
        //     start = i;
        //   }
        //    if(array[i] != ' ' && (i == array.length -1 || array[i+1] == ' '))
        //    {
        //      end  = i;
        //      reverse(array, start, end);
        //    }
        // }
        return new String (array);
    }

    public static String trimSpaces(String s){
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        //remove leading spaces
        while(start < end && array[start] == ' ')
        {
            start++;
        }

        //remove trailing spaces
        while(start < end && array[end] == ' ')
        {
            end--;
        }

        //remove duplicated spaces
        //[start, left) the valid string
        int i = start;
        int left = start;
        while(i <= end)
        {
            if(array[i] == ' ' && array[i-1] == ' ')
            {
                i++;
            }
            else
            {
                array[left++] = array[i++];
            }
        }
        return new String(array, start, left - start);
    }

    public void reverse(char [] array,int start,int end){
        while(start<end){
            swap(array,start,end);
            start++;
            end--;
        }
    }
    public void swap(char [] array,int a,int b){
        char temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public static void main (String args[])
    {
        String input = "  bluee   ";
        String output = reverseWords(input);
        System.out.println(output);
    }
}