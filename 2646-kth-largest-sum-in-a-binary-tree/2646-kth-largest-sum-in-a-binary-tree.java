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
    HashMap<Integer, Long> map = new HashMap<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        helper(root, 0);
        List<Long> res = new ArrayList<>(map.values());
        res.sort((a, b) -> Long.compare(b, a));
        return k > res.size() ? -1 : res.get(k - 1);
    }

    public void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        map.merge(level, (long) root.val, (a, b) -> a + root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}