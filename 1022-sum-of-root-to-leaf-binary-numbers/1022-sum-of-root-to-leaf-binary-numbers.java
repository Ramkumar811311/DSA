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
     static int ans = 0;

    public static void sumOfRootToLeafBinary(TreeNode node, int value) {

        if (node == null) {
            return;
        }
        value = value*2+node.val;
        if (node.left == null && node.right == null) {
            ans += value;
            return;
        }
        sumOfRootToLeafBinary(node.left, value);
        sumOfRootToLeafBinary(node.right, value);

    }
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        sumOfRootToLeafBinary(root, 0);
        return ans;
    }
}