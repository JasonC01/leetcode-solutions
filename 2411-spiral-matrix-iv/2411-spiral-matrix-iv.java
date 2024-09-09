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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] i : ans) {
            Arrays.fill(i, -1);
        }
        int[][] direction = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1 ,0}};
        int dirIndex = 0;
        int currX = -1;
        int currY = 0;
        while (head != null) {
            int nextX = currX + direction[dirIndex][1];
            int nextY = currY + direction[dirIndex][0];
            while (head != null && nextX < n && nextY < m && nextX >= 0 && nextY >= 0 && ans[nextY][nextX] == -1) {
                ans[nextY][nextX] = head.val;
                head = head.next;
                nextX += direction[dirIndex][1];
                nextY += direction[dirIndex][0];
            }
            currX = nextX - direction[dirIndex][1];
            currY = nextY - direction[dirIndex][0];
            dirIndex = (dirIndex + 1) % 4;
        }
        return ans;
    }
}