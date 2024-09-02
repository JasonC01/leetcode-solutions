class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty() || !pairs.containsKey(c) || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
       return stack.isEmpty();
    }
}