public class Solution {
    public int numDecodings1(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[n] = 1;
        nums[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for(int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            nums[i] = nums[i + 1] + getNum(s.charAt(i), s.charAt(i + 1)) <= 26 ? nums[i + 2] : 0;
        }
        return nums[0];
    }

    public int numDecodings(String s) {//too verbose
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
                return 1;
            }
            return 0;
        }

        int[] nums = new int[n];
        nums[0] = 1;
        if (s.charAt(0) == '0' || s.contains("00")) {
            return 0;
        }

        int temp = getNum(s.charAt(0), s.charAt(1));
        if (temp > 26 && temp % 10 == 0) {
            return 0;
        }

        if (s.charAt(1) == '0') {
            nums[1] = 1;
        }else if (temp <= 26) {
            nums[1] = 2;
        } else {
            nums[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            int t = getNum(s.charAt(i - 1), s.charAt(i));
            if (t > 26 && t % 10 == 0) {
                return 0;
            }
            if (s.charAt(i) == '0' || s.charAt(i - 1) == '0') {
                nums[i] = nums[i - 2];
            } else {
                if (t <= 26) {
                    nums[i] = nums[i - 1] + nums[i - 2];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return nums[n - 1];
    }

    private int getNum(char a, char b) {
        return (a - '0') * 10 + b - '0';
    }
}