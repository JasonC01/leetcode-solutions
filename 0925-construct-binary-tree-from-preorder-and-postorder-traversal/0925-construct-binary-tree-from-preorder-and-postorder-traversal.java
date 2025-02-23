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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return node;
        }
        int index = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == preorder[1]) {
                index = i;
                break;
            }
        }
        node.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, index + 2), Arrays.copyOfRange(postorder, 0, index + 1));
        node.right = constructFromPrePost(Arrays.copyOfRange(preorder, Math.min(index + 2, preorder.length), preorder.length), Arrays.copyOfRange(postorder, index + 1, Math.max(index + 1, postorder.length - 1)));
        return node;
    }
}