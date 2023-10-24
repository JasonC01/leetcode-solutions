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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int levelSize = q.size();
        int levelMax = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            levelSize--;
            levelMax = Math.max(curr.val, levelMax);
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (levelSize == 0) {
                ans.add(levelMax);
                levelMax = Integer.MIN_VALUE;
                levelSize = q.size();
            }
        }
        return ans;
    }

}