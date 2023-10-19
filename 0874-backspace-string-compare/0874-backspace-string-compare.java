class Solution {
     public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        return stack1.equals(stack);
    }
}