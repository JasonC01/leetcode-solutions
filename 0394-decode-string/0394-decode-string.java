class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                int repeat = 1;
                StringBuilder rep = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    rep.append(stack.pop());
                }
                repeat = Integer.parseInt(rep.reverse().toString());
                char[] st = sb.reverse().toString().toCharArray();
                for (int i = 0; i < repeat; i++) {
                    for (char ch : st) {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

}