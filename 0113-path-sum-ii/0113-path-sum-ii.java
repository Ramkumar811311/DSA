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
     public static void findAllPath(TreeNode node, int pathSum, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        pathSum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (pathSum == targetSum) {
                ans.add(new ArrayList<>(list));
            }

        }
        findAllPath(node.left, pathSum, targetSum, list, ans);
        findAllPath(node.right, pathSum, targetSum, list, ans);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findAllPath(root, 0, targetSum, list, ans);
        return ans;
    }
}