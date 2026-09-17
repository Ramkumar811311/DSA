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
    public static void deepestLeavesSum(TreeNode node, ArrayList<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(0);
        }
        list.set(level, list.get(level) + node.val);
        deepestLeavesSum(node.left, list, level + 1);
        deepestLeavesSum(node.right, list, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        deepestLeavesSum(root, levelSum, 0);
        return levelSum.get(levelSum.size() - 1);
    }
}