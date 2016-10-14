import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("bdab", "ab"));
    }
    public String minWindow(String s, String t) {
        int[] nums = new int[256];
        boolean[] flag = new boolean[256];
        int count = t.length(), n = s.length();
        for (int i = 0; i < count; i++) {
            nums[t.charAt(i)]++;
            flag[t.charAt(i)] = true;
        }
        Deque<Integer> record = new ArrayDeque<>();
        int l = -1, r = -1, min = Integer.MAX_VALUE, minl = 0, minr = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (flag[c]) {
                if (l == -1) {//initialize l
                    l = i;
                }
                record.add(i);
                nums[c]--;
                if (count != 0) {
                    if (nums[c] >= 0) {
                        count--;
                    }
                }
                if (count == 0) {
                    while (true) {
                        int head = record.peekFirst();
                        if (nums[s.charAt(head)] < 0) {
                            nums[s.charAt(head)]++;
                            record.remove();
                            l = record.peekFirst();
                        } else {
                            break;
                        }
                    }
                    r = i;
                    if (i - l + 1 < min) {
                        min = i - l + 1;
                        minl = l;
                        minr = r;
                    }
                }
            }
        }
        if (count > 0) {
            return "";
        }
        return s.substring(minl, minr + 1);
    }
}