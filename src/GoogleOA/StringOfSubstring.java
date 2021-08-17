package GoogleOA;
/*
given a string A consisting of N chars an a string b consisting of m chars,
return the num of a such that b is a substring of consecutive a.
if b can never be a substring of repeated a, return -1

eg: a = "abcd", b = "cdabcdab", return 3
assume n belongs to [1,1000]
assume m belongs to [1,1000]
 */
public class StringOfSubstring {
    //the initial idea is using two points. The first pointer looping through a string
    //second pointer moves when the current pointing char of first matches the second
    //when the second pointer reaches the end, return the looping time of a

    //cases
    //since b is the substring of consecutive a, the matching should be continuous from the beginning of b to the end of b
    //if b starts matching and then interrupted, if a is in the first loop, second pointer starts from the beginning
    //if b starts matching and then interrupted, if a in is out of first loop, it means there is no starting point of a,
    // , which means b is not a substring of consecutive a, return -1

    //assume null doesn't allow

    //time: O(m + n), space: O(1)
    public static int findNumOfStringOfSubstring(String a, String b) {
        //corner case
        if (a == null || b == null) {
            return -1;
        }

        if (b.length() == 0) {
            return 0;
        }

        //tracking current pointing char
        int pointerA = 0;
        int pointerB = 0;
        int loop = 1;
        boolean start = false;

        //end when pointerB reaches end of b
        while (pointerB < b.length()) {
            if(pointerA == a.length()) {
                loop++;
                pointerA = 0;
            }

            //check char of a and b, if matching
            if (a.charAt(pointerA) == b.charAt(pointerB)) {
                start = true;
                pointerA++;
                pointerB++;
            }

            //not matching
            else {
                //not match for sure, stop
                if (loop != 1) {
                    return -1;
                }

                //start matching from beginning of b
                if(start) {
                    pointerB = 0;
                    start = false;
                }

                //not matching and not start, still in first loop, go check next char in a
                else {
                    pointerA++;
                }
            }
        }
        return loop;
    }
}
