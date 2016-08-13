import java.util.Arrays;

public class Solution {
    public String reverseWords1(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].length() > 0) {
                sb.append(ss[i]).append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).filter(array -> array.length() > 0).reduce("", ((s1, s2) -> s2 + " " + s1)).trim();
    }

}