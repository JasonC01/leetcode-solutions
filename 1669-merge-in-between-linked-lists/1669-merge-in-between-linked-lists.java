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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode endpoint = list1;
        ListNode startPoint = null;
        for (int i = 0; i <= b; i++) {
            if (i == a - 1) {
                startPoint = endpoint;
            }
            endpoint = endpoint.next;
        }
        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }
        startPoint.next = list2;
        list2End.next = endpoint;
        return list1;
    }
}