class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int outOfOrder = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    outOfOrder++;
                } else {
                    stack.pop();
                }
            }
        }
        return outOfOrder + stack.size();
    }
}