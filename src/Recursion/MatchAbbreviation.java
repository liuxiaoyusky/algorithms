package Recursion;

public class MatchAbbreviation {
    /*
    Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".
Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
     */
    public boolean match(String input, String pattern) {
        //two pointers, can be done both by iterative or recursive
        //string doesn't contain numbers,alphabetic characters only; abbreviation has all positive values
        //both input and patern are not null

        int itLength=0;
        int ptLength=0;
        //return matchHelper(input,pattern);
        while(itLength<input.length()&&ptLength<pattern.length()){
            if(pattern.charAt(ptLength)>'9'||pattern.charAt(ptLength)<0){
                //letters, return false when not match
                if(pattern.charAt(ptLength)!=input.charAt(itLength)){
                    return false;
                }
                //true case, check next
                itLength++;
                ptLength++;
            }else{
                //numbers, count how many
                int count=0;
                //ptLength could out of bound, take care!!!!
                while(ptLength<pattern.length()&&pattern.charAt(ptLength)<='9'&&pattern.charAt(ptLength)>='0'){
                    count=10*count+(int)(pattern.charAt(ptLength)-'0');
                    ptLength++;
                }
                itLength+=count;
            }
        }
        //early ends: different length(), not matches
        return itLength==input.length()&&pattern.length()==ptLength;
    }
}
