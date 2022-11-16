package 刷题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        int length;
        public TrieNode(){
            children = new HashMap<>();
            isWord = false;
            length = 0;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        char [] input = s.toCharArray();
        List<Integer> cur = new LinkedList<>();//saves the current starting index of each word
        cur.add(0);

        List<String> ans = new LinkedList<>();

        TrieNode root = toTrie(wordDict);

        helper(input, root, 0, cur, ans);
        return ans;
    }

    private TrieNode toTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            char [] array = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                Map<Character, TrieNode> map = cur.children;
                TrieNode next = map.get(array[i]);
                if (next == null) {
                    next = new TrieNode();
                    map.put(array[i], next);
                }
                cur = next;
            }
            cur.isWord = true;
        }
        return root;
    }

    private void helper(char [] input, TrieNode root, int index, List<Integer> curSol, List<String> ans) {
        //base case
        if (index == input.length) {
            StringBuilder sb = new StringBuilder();
            int charI = 0;
            for (int i = 1; i < curSol.size(); i++) {
                int spaceIndex = curSol.get(i);
                while(charI < spaceIndex) {
                    sb.append(input[charI]);
                    charI++;
                }
                sb.append(' ');
            }

            sb.deleteCharAt(sb.length() - 1);
            ans.add(new String(sb));
            return;
        }

        //general case: try find next word in dict starting from input[index]
        TrieNode cur = root;
        for (int i = index; i <= input.length; i++) {
            //check if still in tree
            if (cur == null) {
                break;
            }

            //check if current is a word
            if (cur.isWord) {
                curSol.add(i);
                helper(input, root, i, curSol, ans);

                //backtrack
                curSol.remove(curSol.size() - 1);
            }

            if (i == input.length) {
                return;
            }

            //search in trie
            Map<Character, TrieNode> map = cur.children;
            cur = map.get(input[i]);
        }
    }
}
