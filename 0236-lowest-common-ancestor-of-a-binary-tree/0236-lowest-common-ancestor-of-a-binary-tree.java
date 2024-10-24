/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean isPLeft = search(root.left, p);
        boolean isQLeft = search(root.left, q);
        if (isPLeft && isQLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (!isPLeft && !isQLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public boolean search(TreeNode curr, TreeNode target) {
        if (curr == null) {
            return false;
        }
        if (curr.val == target.val) {
            return true;
        }
        return search(curr.left, target) || search(curr.right, target);
    }

}