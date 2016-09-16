import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans;
    private int length;
    private String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private char[] cs;
    private String s;

    public List<String> letterCombinations(String digits) {
        s = digits;
        ans = new ArrayList<>();
        length = digits.length();
        cs = new char[length];
        if (s.length() == 0 || s.contains("0") || s.contains("1")) {
            return ans;
        }
        trace(0);
        return ans;
    }

    private void trace(int n) {
        if (n == length) {
            ans.add(new String(cs));
        } else {
            int digit = s.charAt(n) - '0';
            for (int i = 0; i < ss[digit].length(); i++) {
                cs[n] = ss[digit].charAt(i);
                trace(n + 1);
            }
        }
    }
}