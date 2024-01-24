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
    public int pseudoPalindromicPaths (TreeNode root) {
        return helper(root, new HashMap<>());
    }

    public int helper(TreeNode root, HashMap<Integer, Integer> counter) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            counter.merge(root.val, 1, (a, b) -> a + 1);
            int ans = isValid(counter) ? 1 : 0;
            counter.merge(root.val, 0, (a, b) -> a - 1);
            return ans;
        }
        counter.merge(root.val, 1, (a, b) -> a + 1);
        int ans = helper(root.right, counter);
        ans += helper(root.left, counter);
        counter.merge(root.val, 0, (a, b) -> a - 1);
        return ans;
    }

    public boolean isValid(HashMap<Integer, Integer> map) {
        boolean one = false;
        for (int i : map.values()) {
            if (i % 2 == 1 && !one) {
                one = true;
            } else if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}