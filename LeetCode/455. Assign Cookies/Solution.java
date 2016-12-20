import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length, sLength = s.length, i = 0, j = 0, count = 0;
        while (i < gLength && j < sLength) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}