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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        helper(root, 0);
        root.val = 0;
        traverse(root, 0);
        return root;
    }

    public void traverse(TreeNode curr, int level) {
        int leftVal = curr.left == null ? 0 : curr.left.val;
        int rightVal = curr.right == null ? 0 : curr.right.val;
        if (curr.left != null) {
            curr.left.val = map.get(level + 1) - curr.left.val - rightVal;
            traverse(curr.left, level + 1);
        }
        if (curr.right != null) {
            curr.right.val = map.get(level + 1) - curr.right.val - leftVal;
            traverse(curr.right, level + 1);
        }
    }

    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        map.merge(level, root.val, (a, b) -> a + root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}