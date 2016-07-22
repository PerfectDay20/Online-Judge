import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);//sort the array, only compare the first and last item
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = strs.length - 1;
        while (i < strs[0].length() && i < strs[n].length() && strs[0].charAt(i) == strs[n].charAt(i)) {
            sb.append(strs[0].charAt(i));
            i++;
        }
        return sb.toString();
    }
}