import java.util.Set;

public class Solution {
    private int[][] memo;

    public boolean wordBreak1(String s, Set<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        memo = new int[s.length()+1][s.length()+1];
        return wordBreak(s, wordDict, 0, s.length());
    }

    private boolean wordBreak(String s, Set<String> set, int l, int r) {
        if (memo[l][r] == 1) {
            return true;
        } else if (memo[l][r] == -1) {
            return false;
        }
        if (set.contains(s.substring(l, r))) {
            memo[l][r] = 1;
            return true;
        }
        for (int i = l + 1; i <= r; i++) {
            if (set.contains(s.substring(l, i))) {
                if (wordBreak(s, set, i, r)) {
                    memo[l][r] = 1;
                    return true;
                }
            }
        }
        memo[l][r] = -1;
        return false;
    }
}