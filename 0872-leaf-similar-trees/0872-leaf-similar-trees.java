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
    public static void findLeafNode(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        findLeafNode(node.left, list);
        findLeafNode(node.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        findLeafNode(root1, l1);
        findLeafNode(root2, l2);
        if(l1.size()!=l2.size()){
            return false;
        }

        for(int i=0; i<l1.size();i++){
            if(!l1.get(i).equals(l2.get(i))){
                return false;
            }
        }
        return true;

    }
}