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
    static int count = 0;

    public static void countGoodNodes(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            count++;
        }
        countGoodNodes(node.left, Math.max(max, node.val));
        countGoodNodes(node.right, Math.max(max, node.val));
    }
    public int goodNodes(TreeNode root) {
        count=0;
        countGoodNodes(root, root.val);
        return count;
    }
}