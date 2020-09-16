package FinalExam;


import java.util.ArrayList;
import java.util.List;

/*
Given a string, we can insert at most one empty space between each pair of adjacent letters.
Print all permutations of strings after insertions of empty spaces.
Input: str = "ABC"
Output:
ABC
AB_C
A_BC
A_B_C
 */
public class InsertSpaceToString {
    //assume  not null
    //at most one space between each two chars
    //input string output List<String>
    //all subsets
    public List<String> insertSpaceToString(String input){
        List<String> ans=new ArrayList<String>();
        if(input==null){
            return ans;
        }

        char [] array=input.toCharArray();
        StringBuilder sb=new StringBuilder();

        insertSpaceHelper(ans,array,sb,0);

        return ans;
    }
    private void insertSpaceHelper(List<String> ans,char [] array,StringBuilder sb,int index){
        //when index==array.length-1, reach last character, add it to the sb, and add the string to ans
        if(index==array.length-1){
            sb.append(array.length-1);
            ans.add(new String(sb));
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        sb.append(array[index]);
        sb.append(' ');
        insertSpaceHelper(ans,array,sb,index+1);
        //backtrack the space only
        sb.deleteCharAt(sb.length()-1);
        insertSpaceHelper(ans,array,sb,index+1);
    }
}
