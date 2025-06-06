class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 1) return "0";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int curr = Integer.parseInt(num.substring(i, i + 1));
            while (!stack.isEmpty() && k > 0 && stack.peek() > curr) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);
        if (sb.isEmpty()) return "0";
        return sb.toString();
    }
}