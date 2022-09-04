package GraphSearchAlgorithmIII;

import java.util.*;

public class WordLadder {
    //queue for bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //base case
        if(beginWord.equals(endWord)){
            return 1;
        }

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s: wordList) {
            set.add(s);
        }
        map.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        //row = index, column = letter a to z
        boolean [][] allLetters = new boolean [beginWord.length()][26];
        for(int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            for(int j = 0; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                allLetters[j][index] = true;
            }
        }

        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            //base case
            if (cur.equals(endWord)){
                return map.get(cur);
            }
            int steps = map.get(cur) + 1;
            char [] arr = cur.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char start = arr[i];
                char next = start;
                boolean [] letters = allLetters[i];
                for (int j = 0; j < letters.length; j++) {
                    if (letters[j]) {
                        next = (char) ('a' + j);
                        arr[i] = next;
                        String nextWord = new String(arr);
                        if (map.get(nextWord) != null) {
                            continue;
                        }
                        if (!set.contains(nextWord)){
                            continue;
                        }
                        queue.offer(nextWord);
                        map.put(nextWord, steps);
                    }
                }
                //backtrack
                arr[i] = start;
            }
        }
        return 0;
    }
}
