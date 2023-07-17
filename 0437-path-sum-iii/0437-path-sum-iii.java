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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0, targetSum, 0);
    }

    HashMap<TreeNode, HashMap<Integer, HashSet<Long>>> visited = new HashMap<>();
    public int helper(TreeNode curr, long sum, int targetSum, int level) {
        if (curr == null) {
            return 0;
        }
        if (visited.containsKey(curr) && visited.get(curr).containsKey(level) && visited.get(curr).get(level).contains(sum)) {
            return 0;
        }
        int ans = 0;
        if (sum + curr.val == targetSum) {
            ans++;
        }
        if (!visited.containsKey(curr)) {
            visited.put(curr, new HashMap<>());
        }
        visited.get(curr).put(level, new HashSet<>());
        visited.get(curr).get(level).add(sum);
        ans += helper(curr.left, sum + curr.val, targetSum, level + 1) +
                pathSum(curr.left, targetSum) +
                helper(curr.right, sum + curr.val, targetSum, level + 1) +
                pathSum(curr.right, targetSum);

        return ans;
    }
}