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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int remainder = length % k;
        ListNode[] ans = new ListNode[k];
        int n = length / k;
        curr = head;
        int index = 0;
        while (curr != null) {
            ans[index++] = curr;
            for (int i = 0; i < n - 1 + (remainder > 0 ? 1 : 0); i++) {
                curr = curr.next;
            }
            remainder--;
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }
        return ans;
    }
}