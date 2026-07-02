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
class Solution {
    public static ListNode AddTwoLinkList(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        // Node NewHead = new Node(ans);
        // Node temp = NewHead;

        while (temp1 != null || temp2 != null || carry != 0) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            curr.next = newNode;
            curr = curr.next;
        }
        return dummy.next;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode NewHead = AddTwoLinkList(l1,l2);
        return NewHead;
    }
}