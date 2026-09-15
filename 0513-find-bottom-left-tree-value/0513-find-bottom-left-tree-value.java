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
    static int ans=-1;
    static int maxDepth=-1;
    public static void findBottomLeftNode(TreeNode node, int depth){
        if (node==null) {
            return;
        }
        if (depth>maxDepth) {
            ans=node.val;
            maxDepth=depth;
        }
        findBottomLeftNode(node.left, depth+1);
        findBottomLeftNode(node.right, depth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        ans=-1;
        maxDepth=-1;
        findBottomLeftNode(root, 0);
        return ans;
    }
}