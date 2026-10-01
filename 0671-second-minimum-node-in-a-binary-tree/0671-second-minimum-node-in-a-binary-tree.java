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
    static long secondMin;

    public static void findSecondMinNode(TreeNode node,int min) {
        if (node == null) {
            return;
        }
        if (node.val > min) {
            secondMin = Math.min(node.val,secondMin);
            return;
        }
        findSecondMinNode(node.left,min);
        findSecondMinNode(node.right,min);
    }

    public int findSecondMinimumValue(TreeNode root) {
        secondMin = Long.MAX_VALUE;

        findSecondMinNode(root,root.val);

        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }
}