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
    TreeNode ans = null;
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = helper(curr.left) + 1;
        int right = helper(curr.right) + 1;
        if (left > right) {
            ans = map.getOrDefault(curr.left, curr.left);
        } else if (right > left) {
            ans = map.getOrDefault(curr.right, curr.right);
        } else {
            ans = curr;
        }
        map.put(curr, ans);
        return Math.max(left, right);
    }
}