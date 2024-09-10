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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            ListNode gcd = new ListNode(getGCD(curr.val, next.val));
            curr.next = gcd;
            gcd.next = next;
            curr = next;
        }
        return head;
    }

    public int getGCD(int x, int y) {
        for (int i = Math.min(x, y); i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }
}