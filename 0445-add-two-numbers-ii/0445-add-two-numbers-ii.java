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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverseNodes(l1);
        ListNode rev2 = reverseNodes(l2);
        ListNode curr = null;
        int carry = 0;
        int sum = 0;
        while (rev1 != null || rev2 != null) {
            ListNode next = new ListNode();
            if (rev1 == null) {
                sum = rev2.val + carry;
                rev2 = rev2.next;
            } else if (rev2 == null) {
                sum = rev1.val + carry;
                rev1 = rev1.next;
            } else {
                sum = rev1.val + rev2.val + carry;
                rev2 = rev2.next;
                rev1 = rev1.next;
            }
            carry = Math.floorDiv(sum, 10);
            sum %= 10;
            next.val = sum;
            next.next = curr;
            curr = next;
        }
        if (carry > 0) {
            ListNode c = new ListNode(1);
            c.next = curr;
            curr = c;
        }
        return curr;
    }
    
    public ListNode reverseNodes(ListNode l) {
        ListNode prev = null;
        ListNode curr = l;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}