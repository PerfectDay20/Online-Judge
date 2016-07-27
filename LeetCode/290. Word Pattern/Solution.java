import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba","dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> map1 = new HashMap<>();//store the last position they appeared
        Map<String, Integer> map2 = new HashMap<>();
        int n = pattern.length();
        String[] ss = str.split(" ");
        if (n != ss.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (map1.put(pattern.charAt(i), i) != (map2.put(ss[i], i))) {
                return false;
            }
        }
        return true;
    }
}