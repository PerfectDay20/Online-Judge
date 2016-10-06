import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new Solution().partition(s));
    }
    private List<List<String>> ans;
    private List<String> list;
    private char[] cs;
    private int[][] memo;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        cs = s.toCharArray();
        memo = new int[s.length()][s.length()];
        solve(0, cs.length - 1);
        if (isPal(0, cs.length - 1)) {
            list.add(s);
            ans.add(new ArrayList<>(list));

        }
        return ans;
    }

    private void solve(int l, int r) {
        for (int i = l; i < r; i++) {
            boolean left = isPal(l, i), right = isPal(i + 1, r);
            String ls = new String(cs, l, i - l + 1);
            String rs = new String(cs, i + 1, r - i);
            if (left && right) {
                list.add(ls);
                list.add(rs);
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
            if (left) {
                list.add(ls);
                solve(i + 1, r);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(int l, int r) {
        if (l == r) {
            return true;
        }
        if (l > r) {
            return false;
        }
        if (memo[l][r] == 1) {
            return true;
        } else if (memo[l][r] == 2) {
            return false;
        } else {
            if (cs[l] == cs[r]) {
                if (isPal(l + 1, r - 1) || l + 1 == r) {
                    memo[l][r] = 1;
                }
            } else {
                memo[l][r] = 2;
            }
        }
        return memo[l][r] == 1;
    }

}