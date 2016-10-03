/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.out.println(s);
        System.out.println(codec.serialize(codec.deserialize(s)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderSerial(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void preOrderSerial(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#,");
        } else {
            sb.append(node.val).append(",");
            preOrderSerial(sb, node.left);
            preOrderSerial(sb, node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        return preOrderDeserial(ss, new int[]{0});
    }

    private TreeNode preOrderDeserial(String[] ss, int[] i) {
        if (i[0] >= ss.length || ss[i[0]].equals("#")) {
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ss[i[0]++]));
        root.left = preOrderDeserial(ss, i);
        root.right = preOrderDeserial(ss, i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));