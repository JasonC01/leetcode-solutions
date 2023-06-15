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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;
        int levelSum = 0;
        int length = q.size();
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        while (!q.isEmpty()) {
            if (length == 0) {
                if (levelSum > maxSum) {
                    maxSum = levelSum;
                    maxLevel = level;
                }
                length = q.size();
                levelSum = 0;
                level++;
            }
            TreeNode curr = q.poll();
            length--;
            levelSum += curr.val;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return levelSum > maxSum ? level : maxLevel;
    }
}