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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode ptr = new ListNode();
        ListNode dummy = head;
        ListNode next = head;
        while(head != null) {
            next = head.next;
            head.next = ptr;
            ptr = head;
            head = next;
        }
        dummy.next = null;
        return ptr;
    }
}