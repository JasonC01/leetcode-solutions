class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            Optional<Integer> val = convertToInt(s);
            if (val.isPresent()) {
                stack.push(val.get());
            } else {
                int second = stack.pop();
                int first = stack.pop();
                switch (s) {
                    case "+" -> stack.push(first + second);
                    case "-" -> stack.push(first - second);
                    case "*" -> stack.push(first * second);
                    default -> stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }

    public Optional<Integer> convertToInt(String s) {
        try {
            int res = Integer.parseInt(s);
            return Optional.of(res);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}