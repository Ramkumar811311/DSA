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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val + " ");
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                sb.append(curr.left.val + " ");
            } else {
                sb.append("# ");
            }
            if (curr.right != null) {
                q.add(curr.right);
                sb.append(curr.right.val + " ");
            } else {
                sb.append("# ");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] value = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;

        while (!q.isEmpty() && i < value.length) {
            TreeNode parent = q.poll();
            if (i < value.length && !value[i].equals("#")) {
                TreeNode Left = new TreeNode(Integer.parseInt(value[i]));
                q.add(Left);
                parent.left = Left;
            }
            i++;
            if (i < value.length && !value[i].equals("#")) {
                TreeNode Right = new TreeNode(Integer.parseInt(value[i]));
                q.add(Right);
                parent.right = Right;
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));