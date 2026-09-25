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
    static int prev_Num = 0;
    static int c_freq = 0;
    static int m_freq = 0;

    public static void inorder(TreeNode node, List<Integer> mode) {
        if (node == null) {
            return;
        }
        inorder(node.left, mode);

        if (node.val != prev_Num) {
            prev_Num = node.val;
            c_freq = 1;
        } else {
            c_freq++;
        }

        if (c_freq > m_freq) {
            mode.clear();
            mode.add(prev_Num);
        } else if (c_freq == m_freq) {
            mode.add(prev_Num);
        }
        m_freq = Math.max(c_freq, m_freq);

        inorder(node.right, mode);
    }

    public int[] findMode(TreeNode root) {

        List<Integer> mode = new ArrayList<>();
        prev_Num = 0;
        c_freq = 0;
        m_freq = 0;
        inorder(root, mode);
        int[] ans = new int[mode.size()];

        for (int i = 0; i < mode.size(); i++) {
            ans[i] = mode.get(i);
        }

        return ans;
    }
}