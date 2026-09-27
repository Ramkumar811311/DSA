/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public static ListNode findMidNode(ListNode node, int mid) {
        ListNode temp = node;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static TreeNode listToBst(ListNode head, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        ListNode midNode = findMidNode(head, mid);
        TreeNode root = new TreeNode(midNode.val);
        root.left = listToBst(head, low, mid - 1);
        root.right = listToBst(head, mid + 1, high);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return listToBst(head, 0, size - 1);

    }
}