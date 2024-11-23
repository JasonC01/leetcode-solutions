class Solution {
    public String removeDuplicates(String s, int k) {
        if (s.length() < k) {
            return s;
        }
        HashMap<Integer, Integer> counter = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                counter.merge(i, 1, (a, b) -> a + 1);
                stack.push(i);
            } else {
                if (s.charAt(stack.peek()) == s.charAt(i)) {
                    counter.merge(stack.peek(), 1, (a, b) -> a + 1);
                    if (counter.get(stack.peek()) == k) {
                        counter.remove(stack.pop());
                    }
                } else {
                    counter.merge(i, 1, (a, b) -> a + 1);
                    stack.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int i = stack.pop();
            sb.append(String.valueOf(s.charAt(i)).repeat(counter.get(i)));
        }
        return sb.reverse().toString();
    }
}