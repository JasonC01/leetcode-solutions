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
    public TreeNode recoverFromPreorder(String traversal) {
        StringBuilder sep = new StringBuilder("-");
        return helper(traversal, sep);
    }

    public TreeNode helper(String traversal, StringBuilder sep) {
        if (traversal.isEmpty()) {
            return null;
        }
        String[] splitted = traversal.split(String.format("\\b%s\\b", sep.toString()));
        // System.out.println(String.format("\\b%s\\b", sep.toString()));
        // System.out.println(Arrays.toString(splitted));
        TreeNode curr = new TreeNode(Integer.parseInt(splitted[0]));
        sep.append('-');
        if (splitted.length > 1) {
            curr.left = helper(splitted[1], sep);
        }
        if (splitted.length > 2) {
            curr.right = helper(splitted[2], sep);
        }
        sep.deleteCharAt(sep.length() - 1);
        return curr;
    }
}