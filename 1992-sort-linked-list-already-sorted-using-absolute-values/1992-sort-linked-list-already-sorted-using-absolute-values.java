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
    public ListNode sortLinkedList(ListNode head) {
        ListNode tail = head;
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            if (head.val < 0) {
                prev.next = head.next;
                head.next = tail;
                tail = head;
                head = prev.next;
            } else {
                prev = head;
                head = head.next;
            }
            
        }
        return tail;
    }
}