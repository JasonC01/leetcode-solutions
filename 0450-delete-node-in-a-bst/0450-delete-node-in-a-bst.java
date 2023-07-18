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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return mergeTrees(root.left, root.right);
        }
        delete(root, null, key);
        return root;
    }

    public void delete(TreeNode curr, TreeNode parent, int key) {
        if (curr != null) {
            if (curr.val == key) {
                TreeNode merged = mergeTrees(curr.left, curr.right);
                if (parent.val < key) {
                    parent.right = merged;
                } else {
                    parent.left = merged;
                }
            } else {
                delete(curr.left, curr, key);
                delete(curr.right, curr, key);
            }
        }

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode ans = minToTop(t2);
        ans.left = t1;
        return ans;
    }
    
    public TreeNode minToTop(TreeNode t) {
        TreeNode curr = t;
        TreeNode parent = null;
        while (curr.left != null) {
            parent = curr;
            curr = curr.left;
        }
        if (parent == null) {
            return  t;
        } else {
            parent.left = null;
            curr.right = mergeTrees(curr.right, t);
            return curr;
        }
    }
}