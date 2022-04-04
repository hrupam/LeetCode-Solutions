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
        ListNode t=head;
        List<Integer> list=new ArrayList<>();
        while(t!=null){
            list.add(t.val);
            t=t.next;
        }
        
        reverse(list,k-1,list.size()-k);
        ListNode newll=null;
        t=newll;
        for(int i=0;i<list.size();i++){
            if(t==null){
                t=new ListNode(list.get(i));
                newll=t;
            }
            else{
                t.next=new ListNode(list.get(i));
                t=t.next;
            }
        }
        
        return newll;
    }
    
    private static void reverse(List<Integer> list, int i, int j){
        Integer t=list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
    
    
}