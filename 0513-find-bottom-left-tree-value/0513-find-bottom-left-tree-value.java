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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = -1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ans = node.val;
            if (node.right != null) {
                q.add(node.right);
            }
            if (node.left != null) {
                q.add(node.left);

            }
        }
        return ans;
    }
}