import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(100));
    }
    public List<Integer> lexicalOrder(int n) {
        int cur = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while (cur / 10 % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return list;
    }
}