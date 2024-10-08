class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int outOfOrder = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    outOfOrder++;
                } else {
                    stack.pop();
                }
            }
        }
        return (outOfOrder + 1) / 2;
    }
}