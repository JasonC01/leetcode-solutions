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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            List<TreeNode> tn = new ArrayList<>();
            while (!q.isEmpty()) {
                if (q.peek() != null) {
                    tn.add(q.poll());
                } else {
                    q.poll();
                }
            }
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < tn.size(); i++) {
                TreeNode t = tn.get(i);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                arr.add(t.val);
            }
            int[] a = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                a[i] = arr.get(i);
            }
            ans += minSwaps(a);
        }
        return ans;
    }

    public int minSwaps(int[] arr) {
        int swaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] cloned = arr.clone();
        Arrays.sort(cloned);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < cloned.length; i++) {
            if (cloned[i] != arr[i]) {
                int index = map.get(cloned[i]);
                int temp = arr[i];
                arr[i] = cloned[i];
                arr[index] = temp;
                map.put(arr[index], index);
                swaps++;
            }
        }
       return swaps;
    }
}