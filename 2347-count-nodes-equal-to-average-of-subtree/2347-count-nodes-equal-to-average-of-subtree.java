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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }

    public int[] helper(TreeNode curr) {
        if (curr != null) {
            int sum = 0;
            int numberOfNodes = 1;
            int[] left = helper(curr.left);
            int[] right = helper(curr.right);
            sum += left[0];
            sum += right[0];
            sum += curr.val;
            numberOfNodes += left[1];
            numberOfNodes += right[1];
            int average = Math.floorDiv(sum, numberOfNodes);
            if (average == curr.val) {
                ans++;
            }
            return new int[]{sum, numberOfNodes};
        }
        return new int[]{0, 0};
    }
}