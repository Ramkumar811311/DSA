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
    public static boolean f(TreeNode node,int value){
        if(node==null){
            return true;
        }
        if(node.val!=value){
            return false;
        }
        return f(node.left,value) && f(node.right,value);
    }
    public boolean isUnivalTree(TreeNode root) {
        return f(root,root.val);
    }
}