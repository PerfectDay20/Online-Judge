import java.util.*;

class Main {
    private static int min, minNodeVal;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            min = Integer.MAX_VALUE;
            int[] in = stringToInts(sc.nextLine()), post = stringToInts(sc.nextLine());
            Node root = constructTree(in, 0, post, 0, in.length);
            getMin(root);
            System.out.println(minNodeVal);
        }

    }

    private static Node constructTree(int[] in, int iL, int[] post, int pL, int size) {
        if (size <= 0) {
            return null;
        }
        int val = post[pL + size - 1];
        Node root = new Node(val);
        int index = indexOf(in, val);
        int lSize = index - iL, rSize = iL + size - index - 1;
        root.left = constructTree(in, iL, post, pL, lSize);
        root.right = constructTree(in, index + 1, post, pL + lSize, rSize);
        return root;
    }

    private static int indexOf(int[] nums, int t) {
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] == t) {
                return i;
            }
        }
        return -1;
    }

    private static void getMin(Node root) {
        if (root.left == null && root.right == null && root.sum < min) {
            min = root.sum;
            minNodeVal = root.val;
        }
        if (root.left != null) {
            root.left.sum += root.sum;
            getMin(root.left);
        }
        if (root.right != null) {
            root.right.sum += root.sum;
            getMin(root.right);
        }
    }


    private static int[] stringToInts(String s) {
        String[] ss = s.split(" ");
        int n = ss.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        return nums;
    }

}

class Node{
    public int val, sum;
    public Node left, right;

    public Node(int val) {
        this.sum = this.val = val;
    }
}