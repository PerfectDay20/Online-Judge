import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {//add 0 to the tail
                cur *= 10;
            } else if (cur % 10 != 9) {
                if (cur + 1 <= n) {//add 1
                    cur++;
                } else {//cur > n, and not end with 9, so cur/10+1
                    cur = cur / 10 + 1;
                }
            } else {
                while (cur % 10 == 9) {//cur end with 9, must find the first location that is not 9, then + 1
                    cur /= 10;
                }
                cur++;
            }
        }
        return list;
    }
}