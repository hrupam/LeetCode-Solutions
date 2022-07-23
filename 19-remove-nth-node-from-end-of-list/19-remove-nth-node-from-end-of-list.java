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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=getSize(head);
        int loopItr=len-n;
        ListNode prev=null; 
        ListNode curr=head;
        ListNode next=curr.next;
        
        while(loopItr--!=0){
            prev=curr;
            curr=curr.next;
            next=curr.next;
        }
        if(prev==null) return next;
        
        prev.next=next;
        return head;
        
    }
    
    private static int getSize(ListNode head){
        int ctr=0;
        while(head!=null){
            ctr++;
            head=head.next;
        }
        return ctr;
    }
}