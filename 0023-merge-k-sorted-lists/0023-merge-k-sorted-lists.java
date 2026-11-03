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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode l1 = lists[0];
        for(int i=1; i<lists.length; i++){
            ListNode l2 = lists[i];
            ListNode temp1=l1;
            ListNode temp2=l2;
            ListNode dummyNode = new ListNode(0);
            ListNode ans = dummyNode;
            
            while(temp1!=null && temp2!=null){
                if(temp1.val<temp2.val){
                    ans.next=temp1;
                    ans=ans.next;
                    temp1=temp1.next;
                }else{
                    ans.next=temp2;
                    ans=ans.next;
                    temp2=temp2.next;
                }
                
            }
            
            if(temp1==null){
                ans.next=temp2;
            }else{
                ans.next=temp1;
            }
            
            l1=dummyNode.next;
        }
        return l1;
    }
}