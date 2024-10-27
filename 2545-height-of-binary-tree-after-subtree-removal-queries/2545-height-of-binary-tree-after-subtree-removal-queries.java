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
    int[] heights = new int[100001];
    int currMax = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeft(root, 0);
        currMax = 0;
        traverseRight(root, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = heights[queries[i]];
        }
        return ans;
    }

    public void traverseLeft(TreeNode curr, int currHeight) {
        if (curr == null) {
            return;
        }
        
        heights[curr.val] = currMax;
        
        currMax = Math.max(currMax, currHeight);
        
        traverseLeft(curr.left, currHeight + 1);
        traverseLeft(curr.right, currHeight + 1);
    }
    
    public void traverseRight(TreeNode curr, int currHeight) {
        if (curr == null) {
            return;
        }

        heights[curr.val] = Math.max(heights[curr.val], currMax);

        currMax = Math.max(currMax, currHeight);

        traverseRight(curr.right, currHeight + 1);
        traverseRight(curr.left, currHeight + 1);
    }

}