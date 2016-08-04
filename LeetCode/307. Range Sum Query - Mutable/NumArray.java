public class NumArray {
    private int[] sum;
    private int n;


    public NumArray(int[] nums) {
        n = nums.length;
        sum = new int[2 * n];
        System.arraycopy(nums, 0, sum, n, nums.length);
        for (int i = n - 1; i >= 1; i--) {
            sum[i] = sum[i * 2] + sum[i * 2 + 1];
        }
    }

    void update(int i, int val) {
        i += n;
        sum[i] = val;
        while (i > 0) {
            if (i % 2 == 0) {//i is left leaf
                sum[i / 2] = sum[i] + sum[i + 1];
            } else {//i is right leaf
                sum[i / 2] = sum[i - 1] + sum[i];
            }
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        int ans = 0;
        i += n;
        j += n;
        while (i <= j) {
            if (i % 2 == 1) {
                ans += sum[i];
                i++;
            }
            if (j % 2 == 0) {
                ans += sum[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return ans;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);