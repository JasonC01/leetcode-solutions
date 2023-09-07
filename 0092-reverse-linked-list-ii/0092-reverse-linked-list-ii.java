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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode toReverse = null;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        toReverse = prev.next;
        prev.next = null;
        ListNode next = toReverse;
        for (int i = left; i < right; i++) {
            next = next.next;
        }
        ListNode temp = next.next;
        next.next = null;
        next = temp;
        ListNode reversed = reverseList(toReverse);
        prev.next = reversed;
        toReverse.next = next;
        return dummy.next;
    }
}