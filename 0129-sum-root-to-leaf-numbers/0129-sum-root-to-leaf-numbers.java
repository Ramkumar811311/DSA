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
	
	public static void pathSum(TreeNode node, int val) {
		if (node == null) {
			return;
		}
		val = val * 10 + node.val;
		if (node.left == null && node.right == null) {
			ans += val;
			return;
		}
		pathSum(node.left, val);
		pathSum(node.right, val);
	}
    public int sumNumbers(TreeNode root) {
        ans = 0;
		pathSum(root, 0);
		return ans;
    }
}