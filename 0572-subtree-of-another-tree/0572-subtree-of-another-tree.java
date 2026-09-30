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
    public static boolean sameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }
        if (node.val != subRoot.val) {
            return false;
        }
        return sameTree(node.left, subRoot.left) && sameTree(node.right, subRoot.right);
    }

    public static boolean findSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (sameTree(root, subRoot)) {
                return true;
            }
        }
        return findSubTree(root.left, subRoot) || findSubTree(root.right, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findSubTree(root, subRoot);
    }
}