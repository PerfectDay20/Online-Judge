public class Solution {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i : nums) {
            twos |= ones & i;//all bits that appear twice and three times
            ones ^= i;//all bit appear once and three times
            threes = ones & twos;//all bit appear three times
            twos &= ~threes;//delete three times
            ones &= ~threes;
        }
        return ones;
    }

}