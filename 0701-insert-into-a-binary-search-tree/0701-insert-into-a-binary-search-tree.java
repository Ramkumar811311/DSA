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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode parent=null;
        TreeNode node =root;
        while(node!=null){
            if(node.val==val){
                return root;
            }
            else if(node.val>val){
                parent=node;
                node=node.left;
            }
            else{
                parent=node;
                node=node.right;
            }
        }
      

        if(parent.val>val){
            parent.left=new TreeNode(val);
            return root;
        }
        parent.right=new TreeNode(val);
        return root;

    }
}