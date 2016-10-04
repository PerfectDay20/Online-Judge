import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        int count = 0;
        for (String s : strs) {
            String temp = getOrderedString(s);
            if (!map.containsKey(temp)) {
                map.put(temp, count++);
                list.add(new ArrayList<>());
            }
            list.get(map.get(temp)).add(s);
        }
        return list;
    }

    private String getOrderedString(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}