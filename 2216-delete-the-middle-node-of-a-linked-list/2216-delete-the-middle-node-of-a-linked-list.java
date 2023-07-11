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
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int half = Math.floorDiv(length, 2);
        if (half == 0) {
            return head.next;
        }
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < half; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}