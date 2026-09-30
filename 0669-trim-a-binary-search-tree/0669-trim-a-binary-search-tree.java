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
    public static TreeNode trimABst(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }
        if (node.val < low) {
            return trimABst(node.right, low, high);
        }
        if (node.val > high) {
            return trimABst(node.left, low, high);
        }
        TreeNode root = new TreeNode(node.val);
        root.left = trimABst(node.left, low, high);
        root.right = trimABst(node.right, low, high);
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trimABst(root, low, high);
    }
}