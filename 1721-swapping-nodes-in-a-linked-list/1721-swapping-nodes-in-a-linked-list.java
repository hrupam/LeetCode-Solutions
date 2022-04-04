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
    public ListNode swapNodes(ListNode head, int k) {
        int i=k-1;
        int j=getSize(head)-k;
        ListNode l=getNode(head,i);
        ListNode r=getNode(head,j);
        
        int t=l.val;
        l.val=r.val;
        r.val=t;
        
        return head;
    }
    
    private static int getSize(ListNode root){
        int ctr=0;
        while(root!=null){
            ctr++;
            root=root.next;
        }
        return ctr;
    }
    
    private static ListNode getNode(ListNode root, int index){
        int ctr=0;
        while(root!=null){
            ctr++;
            if(ctr==index+1) break;
            root=root.next;
        }
        return root;
    }
    
    
}