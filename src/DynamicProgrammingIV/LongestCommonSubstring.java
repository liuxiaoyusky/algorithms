package DynamicProgrammingIV;

public class LongestCommonSubstring {
    //use 2-d array to keep track the matching status
    public String longestCommon(String source, String target) {
        char [] sources = source.toCharArray();
        char [] targets = target.toCharArray();
        //m [i][j] means the current longest continues substring including sources[i], targets[j]
        //if not equal, make it 0, otherwise, make it m[i - 1][j - 1] + 1

        //track cur longest
        int [] indexes = new int [2];
        int maxLength = 0;

        int [][] m = new int [sources.length] [targets.length];
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < targets.length; j++) {
                if (sources[i] != targets[j]) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    m[i][j] = 1;
                } else {
                    m[i][j] = m[i - 1][j - 1] + 1;
                }

                //update if new longest appear
                if (maxLength < m[i][j]) {
                    maxLength = m[i][j];
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }

        //construct solution
        return new String(sources, indexes[0] - maxLength + 1, maxLength);
    }
}
