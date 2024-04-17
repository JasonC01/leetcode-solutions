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
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return ans;
    }

    public void helper(TreeNode node, StringBuilder curr) {
        if (node == null) {
            return;
        }
        curr.append((char) (node.val + 97));
        if (node.left == null && node.right == null) {
            String rev = curr.reverse().toString();
            curr.reverse();
            ans = ans == null ? rev : ans.compareTo(rev) > 0 ? rev : ans;
            curr.deleteCharAt(curr.length() - 1);
            return;
        }
        helper(node.left, curr);
        helper(node.right, curr);
        curr.deleteCharAt(curr.length() - 1);
    }
}