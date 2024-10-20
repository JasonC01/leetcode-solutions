class Solution {
    public boolean parseBoolExpr(String expression) {
        char curr = expression.charAt(0);
        if (curr == '!') {
            return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        } else if (curr == '&' || curr == '|') {
            List<Boolean> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (char c : expression.substring(2, expression.length() - 1).toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                    sb.append(c);
                } else if (c == ')') {
                    stack.pop();
                    sb.append(c);
                } else if (c == ',' && stack.isEmpty()) {
                    res.add(parseBoolExpr(sb.toString()));
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            if (!sb.isEmpty()) {
                res.add(parseBoolExpr(sb.toString()));
            }
            return curr == '&' ? !res.contains(false) : res.contains(true);
        } else {
            return expression.equals("t");
        }
    }

}