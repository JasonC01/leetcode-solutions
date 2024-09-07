/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
     HashMap<ListNode, HashMap<TreeNode, Boolean>> memo = new HashMap<>();
    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head, head, root);
    }

    public boolean helper(ListNode head, ListNode curr, TreeNode root) {
        if (curr == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (!memo.containsKey(curr)) {
            memo.put(curr, new HashMap<>());
        }
        if (memo.get(curr).containsKey(root)) {
            return memo.get(curr).get(root);
        }
        if (root.val == curr.val) {
            boolean ans = false;
            if (root.val == head.val) {
                ans = helper(head, head.next, root.left) || helper(head, head.next, root.right);
            }
            ans |= (helper(head, curr.next, root.left) || helper(head, curr.next, root.right));
            memo.get(curr).put(root, ans);
            return ans;
        } else {
            boolean ans = false;
            if (head.val == root.val) {
                ans =  helper(head, head.next, root.left) || helper(head, head.next, root.right);
            } else {
                ans = helper(head, head, root.left) || helper(head, head, root.right);
            }
            memo.get(curr).put(root, ans);
            return ans;
        }
    }

}