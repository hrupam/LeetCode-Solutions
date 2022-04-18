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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        
        ListNode temp=head;
        
        int n=right;
        ListNode[] arr=new ListNode[n];
        for(int i=0;i<n;i++){
            arr[i]=temp;
            temp=temp.next;
        }
        
        int i=left-1;
        int j=n-1;
        while(i<j){
            ListNode a=arr[i];
            ListNode b=arr[j];
            swap(a,b);
            i++; j--;
        }
        return head;   
    }
    
    private static void swap(ListNode head, ListNode tail){
        int t=head.val;
        head.val=tail.val;
        tail.val=t;
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