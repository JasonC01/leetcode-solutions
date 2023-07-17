/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> s = new HashSet<>(findPath(root, p, new ArrayList<>()));
        TreeNode ans = null;
        for (TreeNode t : findPath(root, q, new ArrayList<>())) {
            if (s.contains(t)) {
                ans = t;
            }
        }
        return ans;
    }

    public List<TreeNode> findPath(TreeNode curr, TreeNode target, List<TreeNode> path) {
        if (curr == null) {
            return null;
        }
        if (curr.equals(target)) {
            List<TreeNode> ans = new ArrayList<>(path);
            ans.add(curr);
            return ans;
        }
        List<TreeNode> ans = null;
        path.add(curr);
        List<TreeNode> left = findPath(curr.left, target, path);
        path.remove(curr);
        path.add(curr);
        List<TreeNode> right = findPath(curr.right, target, path);
        path.remove(curr);
        return left == null ? right : left;
    }
}