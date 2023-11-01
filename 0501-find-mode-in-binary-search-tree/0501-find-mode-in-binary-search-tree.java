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
    HashMap<Integer, Integer> counter = new HashMap<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int maxValue = 0;
        int maxCount = 0;
        for (int i : counter.values()) {
            if (i > maxValue) {
                maxValue = i;
                maxCount = 1;
            } else if (i == maxValue) {
                maxCount++;
            }
        }
        int[] ans = new int[maxCount];
        int index = 0;
        for (int i : counter.keySet()) {
            if (counter.get(i) == maxValue) {
                ans[index++] = i;
            }
        }
        return ans;
    }
    
    public void helper(TreeNode curr) {
        if (curr != null) {
            counter.merge(curr.val, 1, (a, b) -> a + 1);
            helper(curr.left);
            helper(curr.right);
        }
    }
}