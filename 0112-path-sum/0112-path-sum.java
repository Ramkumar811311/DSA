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
    public  static boolean findPathSum(TreeNode node,int pathSum,int targetSum){
        if (node==null) {
            return false;
        }
        pathSum+=node.val;
        if (node.left==null && node.right==null) {
            return  pathSum==targetSum;
        }
        return findPathSum(node.left, pathSum, targetSum) || findPathSum(node.right, pathSum, targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return findPathSum(root, 0, targetSum);
    }
}