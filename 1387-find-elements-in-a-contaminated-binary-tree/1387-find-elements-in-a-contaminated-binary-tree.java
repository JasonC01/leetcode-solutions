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
class FindElements {

        TreeNode tree;

        public FindElements(TreeNode root) {
            tree = root;
            tree.val = 0;
        }

        public boolean find(int target) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(tree);
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                int currVal = curr.val;
                if (currVal == target) {
                    return true;
                }
                if (curr.left != null) {
                    curr.left.val = currVal * 2 + 1;
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = currVal * 2 + 2;
                    q.add(curr.right);
                }
            }
            return false;
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */