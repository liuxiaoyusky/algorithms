public class AllUniqueCharacterII {
    //don't understand
    //assume using ASCII encoding and the num of valid letters is 256, encoded from 0 to 255
    //word is not null
    public boolean allUnique(String input){
        //each int value can represent 32 bit, so we need 8 ints to represent 256 bits
        int [] vec = new int [8];
        char [] array = input.toCharArray();
        for(char c : array){
            //for a value c in the range of 0-255, it is actually mapped to the int value at c/32 as index,
            //and the c%32th bit of the int value
            if((vec[c/32]>>>(c%32)&1)!=0){
                return false;
            }
            vec[c/32]|=1<<(c%32);
        }
        return true;
    }

    public static void main(String [] args){
        AllUniqueCharacterII allUniqueCharacterII = new AllUniqueCharacterII();
        System.out.println(allUniqueCharacterII.allUnique("abcd123"));
    }
}
