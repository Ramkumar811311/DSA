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
    static int levelX = -1;
	static int levelY = -1;
	
	static TreeNode parentX = null;
	static TreeNode parentY = null;
	public static void find(TreeNode node, int x, int y, int level, TreeNode parent) {
		if (node == null) {
			return;
		}
		if (node.val == x) {
			levelX = level;
			parentX = parent;
		}
		if (node.val == y) {
			levelY = level;
			parentY = parent;
		}
		find(node.left, x, y, level + 1, node);
		find(node.right, x, y, level + 1, node);
	}

    public boolean isCousins(TreeNode root, int x, int y) {
        levelX = -1;
		levelY = -1;
		parentX = null;
		parentY = null;
		
		find(root, x, y, 0, null);
		return levelX == levelY && parentX != parentY;
    }
}