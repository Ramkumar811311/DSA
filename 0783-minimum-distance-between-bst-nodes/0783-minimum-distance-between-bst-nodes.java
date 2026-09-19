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
    static TreeNode prev = null;
    static int ans = Integer.MAX_VALUE;

    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            ans = Math.min(ans, node.val - prev.val);
        }

        prev = node;
        inorder(node.right);
    }
    public int minDiffInBST(TreeNode root) {
        prev=null;
        ans=Integer.MAX_VALUE;
        inorder(root);
        return ans;
    }
}