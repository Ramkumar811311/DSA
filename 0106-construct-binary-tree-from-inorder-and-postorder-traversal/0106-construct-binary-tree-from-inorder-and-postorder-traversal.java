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
    public static TreeNode constructBinaryTree(int postorder[],int posStart, int posEnd, int inorder[],int inStart, int inEnd,HashMap<Integer,Integer> map){
        if (posStart>posEnd || inStart>inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posEnd]);
        int indexOfRoot = map.get(root.val);
        int numsLeft = indexOfRoot-inStart;

        TreeNode Left = constructBinaryTree(postorder, posStart, numsLeft+posStart-1, inorder, inStart, indexOfRoot-1, map);
        root.left=Left;
        TreeNode Right = constructBinaryTree(postorder, posStart+numsLeft, posEnd-1, inorder, indexOfRoot+1, inEnd, map);
        root.right=Right;
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root=constructBinaryTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }
}