class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        HashSet<Character> added = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (added.contains(s.charAt(i))) {
                counter.merge(s.charAt(i), 0, (a, b) -> a - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && counter.get(stack.peek()) > 1) {
                char curr = stack.pop();
                counter.merge(curr, 0, (a, b) -> a - 1);
                added.remove(curr);
            }
//            if (!added.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
                added.add(s.charAt(i));
//            } else {
//                counter.merge(s.charAt(i), 0, (a, b) -> a - 1);
//            }
        }
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}