public class Solution {
    private static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] ss = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int temp = num / nums[i];
            if (temp > 0) {
                for (int j = 0; j < temp; j++) {
                    sb.append(ss[i]);
                }
                num -= temp * nums[i];
            }
        }
        return sb.toString();
    }
}