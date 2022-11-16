package DynamicProgrammingIV;

public class MinimumCutsForPalindromes {
    //use a int [] to count the min cut need at index i (including input.charAt(i))
    public int minCuts(String input) {
        int [] counts = new int [input.length()];
        char [] inputs = input.toCharArray();

        //init count the min palindrome in range [0,i)
        for (int i = 0; i < counts.length; i++) {
            counts[i] = i;
        }

        for (int i = 0; i < inputs.length; i++) {
            if (check(inputs, 0, i)) {
                counts[i] = 0;
                continue;
            }
            for(int j = i; j > 0; j--) {
                //no need to check if too big; otherwise, check if [j,i] is a palindrome
                if (counts[j - 1] + 1 < counts[i]) {
                    if (check(inputs, j, i)) {
                        counts[i] = counts[j - 1] + 1;
                    }
                }
            }
        }

        return counts[counts.length - 1];
    }

    private boolean check(char [] inputs, int a, int b) {
        while (a < b) {
            if (inputs[a] == inputs[b]) {
                a++;
                b--;
            } else {
                return false;
            }
        }
        return true;
    }
}
