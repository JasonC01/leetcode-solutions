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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeaves = new ArrayList<>();
        List<Integer> secondLeaves = new ArrayList<>();
        getLeaf(root1, firstLeaves);
        getLeaf(root2, secondLeaves);
        return firstLeaves.equals(secondLeaves);
    }
    
    public void getLeaf(TreeNode curr, List<Integer> leaves) {
        if (curr != null) {
            if (curr.left == null && curr.right == null) {
                leaves.add(curr.val);
            }
            if (curr.left != null) {
                getLeaf(curr.left, leaves);
            }
            if (curr.right != null) {
                getLeaf(curr.right, leaves);
            }
        }
    }
}