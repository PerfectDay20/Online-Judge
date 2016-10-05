
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connect2(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) {
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
            root = root.left;
        }
    }
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connect(root.left, root.right);
    }

    private void connect(TreeLinkNode l, TreeLinkNode r) {
        if (l == null) {
            return;
        }
        l.next = r;
        connect(l.left, l.right);
        connect(r.left, r.right);
        connect(l.right, r.left);
    }
}