import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
    }
    private Node[] nodes, temp;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        nodes = new Node[n];
        temp = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        Integer[] ans = new Integer[n];
        mergeSort(0, n - 1);
        for (Node node : nodes) {
            ans[node.index] = node.sum;
        }
        return Arrays.asList(ans);
    }

    private void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) >>> 1;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        int i = l, j = m + 1, index = l;
        while (i <= m && j <= r) {
            if (nodes[i].val > nodes[j].val) {
                nodes[i].sum += r - j + 1;
                temp[index++] = nodes[i++];
            } else {
                temp[index++] = nodes[j++];
            }
        }
        while (i <= m) {
            temp[index++] = nodes[i++];
        }
        while (j <= r) {
            temp[index++] = nodes[j++];
        }
        System.arraycopy(temp, l, nodes, l, r - l + 1);
    }
}
class Node{
    int val;
    int index;
    int sum;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }

}
