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
    public static void findlevelSum(TreeNode node, int level, ArrayList<Integer> levelSum) {
        if (node == null) {
            return;
        }
        if (levelSum.size() == level) {
            levelSum.add(0);
        }
        levelSum.set(level, levelSum.get(level) + node.val);
        findlevelSum(node.left, level + 1, levelSum);
        findlevelSum(node.right, level + 1, levelSum);
    }

    public static void changeValue(TreeNode node, int level, ArrayList<Integer> levelSum) {
        if (node == null) {
            return;
        }
        int siblingSum = 0;
        if (node.left != null) {
            siblingSum += node.left.val;
        }
        if (node.right != null) {
            siblingSum += node.right.val;
        }
        if (node.left != null) {
            node.left.val = levelSum.get(level+1) - siblingSum;
        }
        if (node.right != null) {
            node.right.val = levelSum.get(level+1) - siblingSum;
        }
        changeValue(node.left, level + 1, levelSum);
        changeValue(node.right, level + 1, levelSum);

    }

    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        findlevelSum(root, 0, levelSum);
        root.val = levelSum.get(0) - root.val;
        changeValue(root, 0, levelSum);
        return root;
    }
}