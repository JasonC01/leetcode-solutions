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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode firstEven = head.next;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = prev.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = curr.next;
        }
        prev.next = firstEven;
        return head;
    }
}