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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode less = null;
        ListNode more = null;
        ListNode curr = head;
        ListNode ans = null;
        ListNode moreHead = null;
        while (curr != null) {
            if (curr.val < x) {
                if (less == null) {
                    less = curr;
                    ans = curr;
                } else {
                    less.next = curr;
                    less = less.next;
                }
            } else {
                if (more == null) {
                    more = curr;
                    moreHead = curr;
                } else {
                    more.next = curr;
                    more = more.next;
                }
            }
            curr = curr.next;
        }
        if (less != null) {
            less.next = moreHead;
        }
        if (more != null) {
            more.next = null;
        }
        return less == null ? moreHead : ans;
    }
}