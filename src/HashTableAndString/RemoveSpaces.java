package HashTableAndString;

public class RemoveSpaces {
    /*
    Given a string, remove all leading/trailing/duplicated empty spaces.
Assumptions:
    The given string is not null.

Examples:

    “  a” --> “a”
    “   I     love MTV ” --> “I love MTV”
     */
    public static String removeSpaces(String input) {
        //corner case
        if (input == null || input.length() == 0) {
            return input;
        }

        char [] array = input.toCharArray();
        int fast = 0;//index to check
        int slow = 0;//index to place next char
        while (fast < input.length()) {
            if (array[fast] == ' ') {
                //leading empty space
                if (slow == 0) {
                    fast++;
                    continue;
                }

                //dup space
                else if (array[slow - 1] == ' ') {
                    fast++;
                    continue;
                }
            }

            //not space
            array[slow] = array[fast];
            slow++;
            fast++;
        }

        //trailing space
        if (slow != 0 && array[slow - 1] == ' ') {
            slow--;
        }

        return new String(array, 0, slow);
    }

}
