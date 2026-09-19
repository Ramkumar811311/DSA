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
    TreeNode prev = null;
    TreeNode newRoot = null;


    public  void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        if (newRoot == null) {
            newRoot = node;

        } 
        if (prev != null) {
            prev.right = node;
        }
        prev=node;
        node.left=null;
        inorder(node.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;

    }
}