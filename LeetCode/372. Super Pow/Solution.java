public class Solution {
    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= 1337;
        for (int i = 0; i < b.length; i++) {
            int temp1 = powMod(a, b[i]);
            int temp2 = powMod(ans, 10);
            ans = (temp1 * temp2 % 1337);

        }
        return ans;
    }


    static int powMod(int a, int b) {
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans = ans * a % 1337;
        }
        return ans;
    }
}
