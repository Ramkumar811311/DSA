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
    int p_ind = 0;

    public TreeNode constructBinaryTree(int[] inorder, int[] postorder, int start, int end,
            HashMap<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        int n = postorder.length;
        int rootValue = postorder[n - (p_ind) - 1];
        int rootIndexInInorder = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        p_ind++;
        root.right = constructBinaryTree(inorder, postorder, rootIndexInInorder + 1, end, map);
        root.left = constructBinaryTree(inorder, postorder, start, rootIndexInInorder - 1, map);
       
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return constructBinaryTree(inorder, postorder, 0, inorder.length - 1, map);
    }
}