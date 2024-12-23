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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(tree2str(root.left));
        sb.append(")");
        sb.append("(");
        sb.append(tree2str(root.right));
        sb.append(")");
        int end = sb.length();
        while (end >= 2 && sb.substring(end - 2, end).equals("()")) {
            end -= 2;
        }
        return sb.substring(0, end);
    }
}