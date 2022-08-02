package OA.IdealConcepts;

import java.util.LinkedList;
import java.util.List;

/*
sfsf sk"y y"uki

一串string，有空格的地方分开，但是如果是在引号以内则保持原样不分开
 */
public class SplitString {
    public static List<String> split(String input) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new LinkedList<>();
        boolean left = false;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            //in the quote
            if (left) {
                sb.append(cur);
                //check if end
                if (cur == '"') {
                    left = false;
                }
            }

            else {
                if (cur == ' ') {
                    ans.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(cur);
                    if (cur == '"') {
                        left =true;
                    }
                }
            }
        }

        if (sb.length() > 0) {
            ans.add(sb.toString());
        }

        return ans;
    }
}
