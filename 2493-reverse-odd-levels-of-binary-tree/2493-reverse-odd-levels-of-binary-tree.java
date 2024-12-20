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
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public TreeNode reverseOddLevels(TreeNode root) {
        addToMap(root, 0);
        for (int i : map.keySet()) {
            if (i % 2 != 0) {
                List<TreeNode> curr = map.get(i);
                for (int j = 0; j < curr.size() / 2; j++) {
                    int temp = curr.get(j).val;
                    curr.get(j).val = curr.get(curr.size() - 1 - j).val;
                    curr.get(curr.size() - 1 - j).val = temp;
                }
            }
        }
        return root;
    }
    
    public void addToMap(TreeNode curr, int level) {
        if (curr == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(curr);
        addToMap(curr.left, level + 1);
        addToMap(curr.right, level + 1);
    }

}