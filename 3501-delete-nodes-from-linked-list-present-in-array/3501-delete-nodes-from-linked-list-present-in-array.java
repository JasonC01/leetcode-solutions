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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        ListNode ans = head;
        while (ans != null && set.contains(ans.val)) {
            ans = ans.next;
        }
        ListNode curr = ans;
        while (curr != null) {
            ListNode next = curr.next;
            while (next != null && set.contains(next.val)) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
        return ans;
    }
}