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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            level++;
            for(int i=0; i<size; i++){
                  TreeNode node = q.poll();
                if(level==depth-1){
                    TreeNode Left=node.left;
                    TreeNode Right=node.right;
                    node.left = new TreeNode(val);
                    node.right=new TreeNode(val);

                    node.left.left=Left;
                    node.right.right=Right;
                }else{
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }

            }
            if(level==depth-1){
                break;
            }
           
        }
        return root;
    }
}