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
    int p_indx;
    public  TreeNode ConstructTree(int[] preorder, int[] inorder, int start, int end,  HashMap<Integer,Integer> map) {
        if (start > end) {
            return null;
        }
        int rootValue = preorder[p_indx];
        int rootIndexInInorder = map.get(rootValue);
        
        p_indx++;

        TreeNode root = new TreeNode(rootValue);
        root.left = ConstructTree(preorder, inorder, start, rootIndexInInorder - 1,map);
        root.right = ConstructTree(preorder, inorder, rootIndexInInorder + 1, end,map);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }
        return ConstructTree(preorder, inorder, 0, inorder.length-1,map);
    }
}