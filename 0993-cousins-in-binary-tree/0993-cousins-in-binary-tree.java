/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Pair {
        TreeNode node;
        TreeNode parent;

        Pair(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, null));
        while (!q.isEmpty()) {
            TreeNode parent_x = null;
            TreeNode parent_y = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                if (p.node.val == x) {
                    parent_x = p.parent;
                }
                if (p.node.val == y) {
                    parent_y = p.parent;
                }
                if (p.node.left != null) {
                    q.add(new Pair(p.node.left, p.node));
                }
                if (p.node.right != null) {
                    q.add(new Pair(p.node.right, p.node));
                }
            }
            if (parent_x != null && parent_y != null) {
                return parent_x != parent_y;
            }
            if (parent_x != null || parent_y != null) {
                return false;
            }
        }
        return false;
    }
}