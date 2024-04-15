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
    public int sumNumbers(TreeNode root) {
        return helper(root, new StringBuilder());
    }

    public int helper(TreeNode node, StringBuilder curr) {
        if (node == null) {
            return 0;
        }
        curr.append(node.val);
        if (node.left == null && node.right == null) {
            int res = Integer.parseInt(curr.toString());
            curr.deleteCharAt(curr.length() - 1);
            return res;
        }
        int res = helper(node.left, curr) + helper(node.right, curr);
        curr.deleteCharAt(curr.length() - 1);
        return res;
    }
}