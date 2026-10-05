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
    public static int findMaxIndInArr(int low,int high,int []nums){
        int maxValue =-1;
        int maxInd = -1;

        for(int i=low; i<=high; i++){
            if(nums[i]>maxValue){
                maxValue=nums[i];
                maxInd=i;
            }
        }
        return maxInd;
    }
    public static TreeNode constructTreeNode(int []nums,int low, int high){
        if(low>high){
            return null;
        }
        int maxIndex = findMaxIndInArr(low,high,nums);
        int maxValue = nums[maxIndex];
        TreeNode root = new TreeNode(maxValue);
        root.left=constructTreeNode(nums,low,maxIndex-1);
        root.right=constructTreeNode(nums,maxIndex+1,high);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTreeNode(nums,0,nums.length-1);
    }
}