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
        int rem = length % k;
        int val = Math.floorDiv(length, k);
        System.out.println(val);
        System.out.println(rem);
        ListNode[] ans = new ListNode[k];
        Arrays.fill(ans, null);
        curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            ListNode res = curr;
            for (int j = 0; j < val + (rem > 0 ? 1 : 0) - 1 && res != null; j++) {
                res = res.next;
            }
            rem--;
            ListNode next = res == null ? null : res.next;
            if (res != null) {
                res.next = null;
            }
            ans[i] = curr;
            curr = next;
        }
        return ans;
    }
}