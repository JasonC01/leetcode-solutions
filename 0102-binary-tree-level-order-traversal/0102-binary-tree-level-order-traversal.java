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
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        return new ArrayList<>(map.values());
    }

    public void helper(TreeNode curr, int level, HashMap<Integer, List<Integer>> map) {
        if (curr == null) {}
        else {
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(curr.val);
            helper(curr.left, level + 1, map);
            helper(curr.right, level + 1, map);
        }
    }
}