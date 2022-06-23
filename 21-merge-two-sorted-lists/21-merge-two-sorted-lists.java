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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode t = head;
        ListNode p = list1, q = list2;
        while((p != null) && (q != null)) {
            if(p.val <= q.val) {
                t.next = p;
                p = p.next;
            } else {
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }
        while(p != null) {
            t.next = p;
            p = p.next;
            t = t.next;
        } 
        while(q != null) {
            t.next = q;
            q = q.next;
            t = t.next;
        }
        return head.next;
    }
    //      p
    //1-2-4
    //1-3-4
    //    q
    //n-1-1-2-3-4
    //          t
}