/**
 * Definition for a binary tree root.
 * public class Treeroot {
 *     int val;
 *     Treeroot left;
 *     Treeroot right;
 *     Treeroot() {}
 *     Treeroot(int val) { this.val = val; }
 *     Treeroot(int val, Treeroot left, Treeroot right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode  root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return 0;
    }
}