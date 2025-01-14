/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // root, left, right
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("[-1]");
            return sb.toString();
        }
        sb.append('[');
        sb.append(root.val);
        sb.append(',');
        sb.append(serialize(root.left));
        sb.append(',');
        sb.append(serialize(root.right));
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> values = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < data.length() - 1; i++) {
            if (data.charAt(i) == '[') {
                stack.push('[');
                sb.append('[');
            } else if (data.charAt(i) == ']') {
                stack.pop();
                sb.append(']');
            } else if (data.charAt(i) == ',') {
                if (stack.isEmpty()) {
                    values.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(data.charAt(i));
                }
            } else {
                sb.append(data.charAt(i));
            }
        }
        values.add(sb.toString());
        if (values.size() == 1) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values.get(0)));
        root.left = deserialize(values.get(1));
        root.right = deserialize(values.get(2));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));