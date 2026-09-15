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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List <Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return ans;
        }

        queue.add(root);

        int flag=0;

        while (!queue.isEmpty()) {
            List<Integer> list= new ArrayList<>();
            int length=queue.size();

            for(int i=0;i<length; i++){
                TreeNode node = queue.peek();
                if (flag==0) {
                    list.add(node.val);
                }
                else{
                    list.add(0,node.val);
                }

                queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            flag = 1-flag;
            ans.add(list);
        }
        return ans;
    }
}