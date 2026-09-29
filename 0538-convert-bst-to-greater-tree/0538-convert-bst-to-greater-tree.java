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
    static int sum = 0;

    public static void convertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        convertTree(node.right);
        sum += node.val;
        node.val = sum;
        convertTree(node.left);
    }
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        convertTree(root);
        return root;
    }
}