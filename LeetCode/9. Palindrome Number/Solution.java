public class Solution {
    public boolean isPalindrome(int x) {
        int ans = 0;
        if (x < 0 || x % 10 == 0 && x != 0) {//negative and end with 0
            return false;
        }
        while (ans < x) {//only compare first half and second half
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return x == ans || ans / 10 == x;//even digits or odd digits
    }
}