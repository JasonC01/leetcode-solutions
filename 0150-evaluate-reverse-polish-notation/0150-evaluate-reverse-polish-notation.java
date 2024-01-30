class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                s.addLast(Integer.parseInt(token));
            } else {
                int second = s.pollLast();
                int first = s.pollLast();
                int res = 0;
                if (token.equals("+")) {
                    res = first + second;
                } else if (token.equals("-")) {
                    res = first - second;
                } else if (token.equals("/")) {
                    res = first/second;
                } else {
                    res = first * second;
                }
                s.addLast(res);
            }
        }
        return s.pop();
    }

    public boolean isNumber(String s) {
        if (s.length() == 1 && s.charAt(0) == '-') {
            return false;
        }
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}