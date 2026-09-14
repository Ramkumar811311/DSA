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
    public static int sumOfAllLeafNode(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            if (isLeft) {
                 return node.val;
            }
        }
        return sumOfAllLeafNode(node.left,true) + sumOfAllLeafNode(node.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfAllLeafNode(root, false);
    }
}