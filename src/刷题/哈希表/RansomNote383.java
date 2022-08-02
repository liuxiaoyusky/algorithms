package 刷题.哈希表;

public class RansomNote383 {
    //input:two string
    //output: boolean
    //assume all lowercase letters
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            letters[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            letters[index]--;
            if (letters[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
