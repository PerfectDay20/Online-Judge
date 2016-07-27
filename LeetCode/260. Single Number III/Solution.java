public class Solution {
    public int[] singleNumber(int[] nums) {
        int dif = 0;
        for (int i : nums) {
            dif ^= i;
        }
        int dif1 = Integer.lowestOneBit(dif);//use this number to divide nums into two parts, either has an answer
        int a = 0;
        for (int i : nums) {
            if ((dif1 & i) != 0) {
                a ^= i;
            }
        }
        int b = a ^ dif;
        return new int[]{a, b};
    }
}