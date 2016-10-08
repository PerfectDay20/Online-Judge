import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String num = "121474836472147483648";
        System.out.println(new Solution().isAdditiveNumber(num));

    }
    private List<Long> list;//using long to avoid overflow
    private int n;
    private String s;

    public boolean isAdditiveNumber(String num) {
        s = num;
        n = s.length();
        list = new ArrayList<>();
        if (n < 3) {//at least three char
            return false;
        }
        return helper(0);
    }

    private boolean helper(int left) {
//        System.out.println(list);

        if (left == n) {//terminate condition
            return list.size() >= 3;
        }

        int lastSize = 1, listSize = list.size();
        if (listSize >= 2) {//every number has to larger than the last one, except for first twos
            lastSize = list.get(list.size() - 1).toString().length();
        }
        for (int i = left + lastSize; i <= n && i < left + 11; i++) {//at most 10 digits
            if (s.charAt(left) == '0' && left + 1 < i) {//can't start with 0 except for 0 itself
                continue;
            }
            long t = Long.parseLong(s.substring(left, i));
            if (listSize < 2) {
                list.add(t);
                if (helper(i)) {
                    return true;
                }
                list.remove(listSize);
            } else {
                if (list.get(listSize - 2) + list.get(listSize - 1) == t) {
                    list.add(t);
                    if (helper(i)) {
                        return true;
                    }
                    list.remove(listSize);
                }
            }
        }
        return false;
    }


}