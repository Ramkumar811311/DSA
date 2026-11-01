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
class BSTIterator {
    Stack <TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root,st);
    }
    
    public int next() {
        TreeNode tempNode = st.pop();
        pushAll(tempNode.right,st);
        return tempNode.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
    public static void pushAll(TreeNode node,Stack <TreeNode> st){
        while(node!=null){
            st.push(node);
            node=node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */