package OA.uworld;

public class StringRemoveDupAndReturnMax {

    //check if front dup is larger than following
    //otherwise delete
    //if char[i] is deleted, check the char[i - 1] again if it has dup, chars[] > 0
        // if char[i - 1] > char[i], stop, otherwises, delete and check further
    public String doit(String inputS) {
        char [] chars = new char[26];//how many chars in searching space
        char [] input = inputS.toCharArray();
        boolean [] exists = new boolean[26];//how many chars in reserve space
        //get how many counts
        for (char c : input) {
            chars[c - 'a']++;
        }

        //[0,right) keep, [right,i) delete, [i,] check
        int right = 0;
        for (int i = 0; i < input.length; i++) {
            char cur = input[i];
            //delete cur directly
            if (exists[cur - 'a']) {
                //check if we need to delete front
                while (i < input.length - 1 && right > 0) {
                    char prev = input[right - 1];
                    char next = input[i + 1];
                    if (chars[prev - 'a'] > 0 && prev < next) {
                        right--;
                        exists[prev - 'a'] = false;
                    } else {
                        break;
                    }
                }
                chars[cur - 'a']--;
            }

            //first char ever seen
            else {
                //only one
                if (chars[cur- 'a'] == 1) {
                    input[right] = cur;
                    right++;
                    exists[cur - 'a'] = true;
                    chars[cur - 'a']--;
                }

                //check if we need to save it for dups
                else {
                    //delete cur
                    if (i < input.length - 1 && cur < input[i + 1]) {
                        //check if we need to delete front
                        while (right > 0) {
                            char prev = input[right - 1];
                            char next = input[i + 1];
                            if (chars[prev - 'a'] > 0 && prev < next) {
                                right--;
                                exists[prev - 'a'] = false;
                            }else {
                                break;
                            }
                        }
                        chars[cur - 'a']--;
                    } else {
                        input[right] = cur;
                        right++;
                        exists[cur - 'a'] = true;
                        chars[cur - 'a']--;
                    }
                }
            }
        }

        return new String(input, 0, right);

    }
}
