/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            pq.add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        int prev = pq.poll();
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            ans = Math.min(curr - prev, ans);
            prev = curr;
        }
        return ans;
    }
}