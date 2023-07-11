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
    List<List<Integer>> adjList = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        for (int i = 0; i < 500; i++) {
            adjList.add(new ArrayList<>());
        }
        generateGraph(root);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(target.val);
        boolean[] visited = new boolean[500];
        int level = 0;
        int length = 1;
        while (!q.isEmpty() && level < k) {
            int curr = q.poll();
            visited[curr] = true;
            length -=1;
            for (int adj : adjList.get(curr)) {
                if (!visited[adj]) {
                    q.add(adj);
                }
            }
            if (length == 0) {
                level += 1;
                length = q.size();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }

    public void generateGraph(TreeNode curr) {
        if (curr != null) {
            if (curr.left != null) {
                adjList.get(curr.val).add(curr.left.val);
                adjList.get(curr.left.val).add(curr.val);
                generateGraph(curr.left);
            }
            if (curr.right != null) {
                adjList.get(curr.val).add(curr.right.val);
                adjList.get(curr.right.val).add(curr.val);
                generateGraph(curr.right);
            }
        }
    }
}