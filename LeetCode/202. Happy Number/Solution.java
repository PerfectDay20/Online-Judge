public class Solution {//use the same method as find circle in link list
    public boolean isHappy(int n) {
        int fast = getNext(getNext(n));
        int slow = getNext(n);
        while (fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }
        return ans;
    }
}