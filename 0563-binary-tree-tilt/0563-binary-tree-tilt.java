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
    static int sumTilt = 0;

    public static int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = postorder(node.left);
        int rightSum = postorder(node.right);
        sumTilt += Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        sumTilt = 0;
        postorder(root);
        return sumTilt;
    }
}