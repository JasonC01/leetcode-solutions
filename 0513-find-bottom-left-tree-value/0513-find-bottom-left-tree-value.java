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
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, 0)[0];
    }
    
    public int[] helper(TreeNode node, int currDepth) {
        if (node == null) {
            return new int[]{0, 0};
        }
        if (node.right == null && node.left == null) {
            return new int[]{node.val, currDepth};
        }
        int[] left = helper(node.left, currDepth + 1);
        int[] right = helper(node.right, currDepth + 1);
        int lDepth = left[1];
        int lVal = left[0];
        int rDepth = right[1];
        int rVal = right[0];
        if (lDepth == rDepth) {
            return left;
        } else {
            return lDepth > rDepth ? left : right;
        }
    }
}