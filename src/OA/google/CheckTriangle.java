package OA.google;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckTriangle {

    public boolean checkTriangle(String bottom, List<String> patterns) {
        HashMap<String, List<Character>> upper_letters = findAllLetter(bottom,patterns);
        char [] upper_bottom = new char[bottom.length() - 1];
        return dfsNextLevel(upper_bottom, 0, upper_letters, patterns);
    }

    private boolean dfsNextLevel(char [] upper_bottom, int index,  HashMap<String, List<Character>> upper_letters, List<String> patterns) {
        //base case
        if (index == upper_bottom.length) {
            boolean result = checkTriangle(new String(upper_bottom),patterns);
        }

//        int curList =
        return false;
    }

    private HashMap<String, List<Character>> findAllLetter(String bottom,List<String> patterns) {
        HashMap<String, List<Character>> upper_letters = new HashMap<>();
        for(int i = 0; i < bottom.length() - 1; i++) {
            String cur_bottom = bottom.substring(i, i + 2);
            List<Character> cur_tops = new ArrayList<>();
            if (upper_letters.get(cur_bottom)!= null) {
                continue;
            } else {
                for (String pattern: patterns) {
                    for (int j = 0; j < cur_bottom.length(); j++) {
                        if (cur_bottom.charAt(j) != pattern.charAt(j)){
                            break;
                        }
                    }
                    cur_tops.add(pattern.charAt(2));
                }

                upper_letters.put(cur_bottom,cur_tops);
            }
        }
    return upper_letters;
    }

}
