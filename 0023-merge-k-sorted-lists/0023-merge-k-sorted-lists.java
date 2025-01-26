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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(x -> x.val));
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        ListNode head = pq.peek();
        ListNode cumulative = null;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            ListNode next = curr.next;
            if (next != null) {
                pq.add(next);
            }
            if (cumulative == null) {
                cumulative = curr;
            } else {
                cumulative.next = curr;
                cumulative = curr;
            }
        }
        return head;
    }
}