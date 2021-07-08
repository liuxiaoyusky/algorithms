package DynamicProgramming.dp2;
/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions

    Both strings are not null

Examples

string one: “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 */
public class EditDistance {
    //base case:
    //for each step, compare one letter of both string; eg: a in ab, and 1 in 12;
    //add a char on other string = move forward on current string; ab vs a12 => (b vs 12)
    //delete the char of other string = move forward on other string; ab vs 2 => (ab vs 2)
    //replace the car of the other string = move forward on both string; ab vs a2 => (b vs 2)
    //rule: for ij, if i != j, find min[(i - 1 , j) + 1, (i, j - 1) + 1, (i- 1,j - 1) + 1]
    public static int editDistance(String one, String two) {
        //corner case
        if (one.length() == 0) {
            return two.length();
        } else if (two.length() == 0) {
            return one.length();
        }

        //memory
        int [][] m = new int [one.length() + 1] [two.length() + 1];//loc between two char
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                //base case
                if (i == 0) {
                    m[i][j] = j;
                }

                else if ( j == 0) {
                    m[i][j] = i;
                }

                //same letter
                else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    m[i][j] = m[i - 1] [j - 1];
                }

                else {
                    m[i][j] = Math.min(m[i - 1] [j] + 1, m[i] [j - 1] + 1);
                    m[i][j] = Math.min(m[i] [j], m[i - 1] [j - 1] + 1);
                }
            }
        }

        return m[one.length()][two.length()];
    }
}
