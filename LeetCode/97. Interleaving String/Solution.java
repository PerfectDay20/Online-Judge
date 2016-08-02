public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] insert = new boolean[s1.length() + 1][s2.length() + 1];//insert[i][j] means can s3[i+j-1] insert into s1[i-1] s2[j-1]
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    insert[i][j] = true;
                } else if (i == 0) {
                    insert[i][j] = insert[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
                } else if (j == 0) {
                    insert[i][j] = insert[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                } else {
                    insert[i][j] = insert[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) || insert[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return insert[s1.length()][s2.length()];
    }
}