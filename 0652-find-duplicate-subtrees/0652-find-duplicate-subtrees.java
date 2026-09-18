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
    public static String getSubTreeString(TreeNode node, List<TreeNode> list, HashMap<String, Integer> map) {
        if (node == null) {
            return "N";
        }
        String s = Integer.toString(node.val) + "," + getSubTreeString(node.left, list, map) + ","
                + getSubTreeString(node.right, list, map);
        if (!map.containsKey(s)) {
            map.put(s, 1);
        } else {
            if (map.get(s) == 1) {
                list.add(node);
            }
            map.put(s, map.get(s) + 1);
        }

        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        getSubTreeString(root, list, map);
        return list;
    }
}