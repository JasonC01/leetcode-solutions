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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, 1 + minDepth(root.left));
        }
        if (root.right != null) {
            ans = Math.min(ans, 1 + minDepth(root.right));
        }
        return ans == Integer.MAX_VALUE ? 1 : ans;
    }
}