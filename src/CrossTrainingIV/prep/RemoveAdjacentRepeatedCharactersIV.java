package CrossTrainingIV.prep;
/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples
    "abbbaaccz" → "aaaccz" → "ccz" → "z"
    "aabccdc" → "bccdc" → "bdc"
 */
public class RemoveAdjacentRepeatedCharactersIV {
    //[0, left] is answers
    //right is what we are looking currently
    public String deDup(String input) {
        char [] array = input.toCharArray();
        int left = -1;
        int right = 0;
        while (right < array.length) {
            if (left < 0 || array[right] != array[left]) {
                array[++left] = array[right++];
            } else if (array[right] == array[left]) {
                left--;
                while(right + 1 < array.length && array[right] == array[right + 1]) {
                    right++;
                }
                right++;
            }
        }

        return new String(array, 0, left + 1);
    }
}
