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
    public static String constructString(TreeNode node) {
        if (node == null) {
            return "";
        }
        String result = Integer.toString(node.val);

        String left = constructString(node.left);
        String right = constructString(node.right);
        if (node.left == null && node.right == null) {
            return result;
        }
        if (node.left == null) {
            return result + "()" + "(" + right + ")";
        }
        if (node.right == null) {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }
    public String tree2str(TreeNode root) {
        return  constructString(root);
    }
}