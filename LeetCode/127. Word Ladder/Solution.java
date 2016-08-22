import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "hig";

        Set<String> wordList = new HashSet<>();
        System.out.println(new Solution().ladderLength(begin, end, wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int n = wordList.size(), wl = beginWord.length();
        Map<String, Boolean> visit = new HashMap<>();

        Set<String> newSet = new HashSet<>(wordList);
        newSet.add(beginWord);
        newSet.add(endWord);

        for (String s : newSet) {
            visit.put(s, false);
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visit.put(beginWord, true);
        int level = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String head = queue.remove();
                for (int j = 0; j < head.length(); j++) {
                    char[] cs = head.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        cs[j] = c;
                        String newS = new String(cs);
                        if (newSet.contains(newS) && !visit.get(newS)) {
                            if (newS.equals(endWord)) {
                                return level;
                            }
                            queue.add(newS);
                            visit.put(newS, true);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

}
