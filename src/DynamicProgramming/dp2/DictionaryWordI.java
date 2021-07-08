package DynamicProgramming.dp2;
/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

    The given word is not null and is not empty
    The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples

Dictionary: {“bob”, “cat”, “rob”}

    Word: “robob” return false

    Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 */
public class DictionaryWordI {
    //rule: for each char, try looking backwards for length of words, if the prevous loc is true and
    // match one of the words in dict, break and mark true; else, return false
    public static boolean canBreak(String input, String[] dict) {
        //corner case
        if (input == null || input.length() == 0) {
            return true;
        }

        if (dict == null || dict.length == 0) {
            return false;
        }

        boolean [] memory = new boolean [input.length() + 1];//contains the info of breakable
        memory[0] = true;
        //go through every char by the rule
        for(int i = 0; i < input.length(); i++) {
            //check length
            for(String cur : dict) {
                if ((i + 1 - cur.length()) >= 0 && memory[i + 1 - cur.length()]) {
                    //try match, can also use set.contains(input.substring(j,i)) to check
                    boolean mismatch = false;
                    for(int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != input.charAt(i - cur.length() + 1 + j)) {
                            mismatch = true;
                            break;
                        }
                    }
                    //check all matches
                    if(!mismatch) {
                        memory[i + 1] = true;
                        break;
                    }
                }
            }
        }
        return memory[input.length()];
    }
    public static void main ( String [] args) {
        canBreak("robcatd", new String[] {"rob","cat","d"});
        canBreak("abcdddef", new String[]{"abc","ab","cd","de","def"});
    }
}
