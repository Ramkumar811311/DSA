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
    public  static  int findMin_depth(TreeNode node){
        if (node==null){
            return 0;
        }
         if (node.right == null && node.left == null) {
            return 1;
        }
        if (node.left == null) {
            return 1 + findMin_depth(node.right);
        }
        if (node.right == null) {
            return 1 + findMin_depth(node.left);
        }
        int lh=findMin_depth(node.left);
        int rh=findMin_depth(node.right);
        return 1+Math.min(lh, rh);
    }
    public int minDepth(TreeNode root) {
        return findMin_depth(root);
    }
}