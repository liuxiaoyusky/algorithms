package aaaaaaaaa暂时不懂;

/*
Given two binary strings, return their sum (also a binary string).
Input: a = “11”
           b = “1”
Output: “100”
 */

//use string builder
//input: two strings
//output: string
public class AddBinary {
    //looking from back to front
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();//reverse at last
        int lengthLonger = Math.max(a.length(), b.length());
        int lengthShorter = Math.min(a.length(), b.length());
        String longerString = a.length() > b.length()? a : b;
        int curIndex = 1;
        int sum = 0;//used for advanced number
        while (curIndex <= lengthLonger) {
            //add together with a and b
            if (curIndex <= lengthShorter) {
                int aChar = a.charAt(a.length() - curIndex) - '0';
                int bChar = b.charAt(b.length() - curIndex) - '0';
                sum += (aChar + bChar);
            }
            //only add the longer string
            else {
                int newChar = longerString.charAt(lengthLonger - curIndex) - '0';
                sum += newChar;
            }
            sb.insert(0,sum % 2);
            sum = sum / 2;
            curIndex++;
        }

        //append if longer than a and b
        while (sum != 0) {
            sb.insert(0,sum % 2);
            sum = sum / 2;
        }

        return sb.toString();
    }
}
