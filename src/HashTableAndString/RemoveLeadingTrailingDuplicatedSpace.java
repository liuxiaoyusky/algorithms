package HashTableAndString;

public class RemoveLeadingTrailingDuplicatedSpace {
    public String removeSpaces(String input) {
        char[] array=input.toCharArray();
        if(input.length()==0){
            return input;
        }
        int slow=0;//[0,slow)are valid
        boolean multipleSpace=false;
        for(int fast=0;fast<array.length;fast++){
            if(array[fast]==' '){
                //leading space
                if(slow==0){
                    continue;
                }else if(multipleSpace==true){
                    continue;
                }else{
                    multipleSpace=true;
                    array[slow]=array[fast];
                    slow++;
                }
            }else{
                //things other than space
                multipleSpace=false;
                array[slow]=array[fast];
                slow++;
            }
        }
        //check trailing space
        //!!!!!be careful!slow could out of bound
        if(slow>0&&array[slow-1]==' '){
            slow--;
        }

        return new String(array,0,slow);
    }
}

