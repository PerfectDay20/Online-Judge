import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAAAAGGGTTT";
        System.out.println(new Solution().findRepeatedDnaSequences(s));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i + 10 <= n; i++) {
            String temp = s.substring(i, i + 10);
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                int count = map.get(temp);
                if (count == 1) {
                    map.put(temp, 2);
                    list.add(temp);

                }
            }
        }
        return list;
    }
}