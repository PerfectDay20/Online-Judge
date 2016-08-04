public class NumArray1 {//using Fenwick Tree
    private int[] sum;
    private int[] nums;

    public NumArray1(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            adjust(i, nums[i]);
        }
    }

    private void adjust(int i, int gap) {
        for (++i; i < sum.length; i += LSOne(i)) {
            sum[i] += gap;
        }
    }

    private int LSOne(int n) {
        return n & -n;
    }

    void update(int i, int val) {
        int gap = val - nums[i];
        nums[i] = val;
        adjust(i, gap);
    }

    public int sumRange(int i, int j) {
        return i == 0 ? cum(j) : cum(j) - cum(i - 1);
    }

    private int cum(int n) {
        int ans = 0;
        for (n++; n > 0; n -= LSOne(n)) {
            ans += sum[n];
        }
        return ans;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);