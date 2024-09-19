class Solution {
    public class TreeNode {
      String val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(String val) { this.val = val; }
      TreeNode(String val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (isNumeric(String.valueOf(currChar))) {
                int index = i + 1;
                while (index < expression.length() && isNumeric(String.valueOf(expression.charAt(index)))) {
                    index++;
                }
                nums.add(Integer.parseInt(expression.substring(i, index)));
                i = index - 1;
            } else {
                ops.add(currChar);
            }
        }
        return helper(nums, ops);
    }

    public List<Integer> helper(List<Integer> nums, List<Character> ops) {
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> res = generateTree(nums, ops);
        for (TreeNode t : res) {
            ans.add(traverseTree(t));
        }
        return ans;
    }
    
    public List<TreeNode> generateTree(List<Integer> nums, List<Character> ops) {
        List<TreeNode> ans = new ArrayList<>();
        if (nums.size() == 1) {
            ans.add(new TreeNode(String.valueOf(nums.get(0))));
            return ans;
        }
        for (int i = 0; i < ops.size(); i++) {
            List<Integer> left = new ArrayList<>(nums.subList(0, i + 1));
            List<Integer> right = new ArrayList<>(nums.subList(i + 1, nums.size()));
            List<Character> lOps = new ArrayList<>(ops.subList(0, i));
            List<Character> rOps = new ArrayList<>(ops.subList(i + 1, ops.size()));
            List<TreeNode> leftNodes = generateTree(left, lOps);
            List<TreeNode> rightNodes = generateTree(right, rOps);
            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    TreeNode res = new TreeNode(String.valueOf(ops.get(i)));
                    res.left = l;
                    res.right = r;
                    ans.add(res);
                }
            }
        }
        return ans;
    }
    public int traverseTree(TreeNode node) {
        if (isNumeric(node.val)) {
            return Integer.parseInt(node.val);
        }
        return compute(traverseTree(node.left), traverseTree(node.right), node.val);
    }

    public Integer compute(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }

    public boolean isNumeric(String c) {
        try {
            Integer.parseInt(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}