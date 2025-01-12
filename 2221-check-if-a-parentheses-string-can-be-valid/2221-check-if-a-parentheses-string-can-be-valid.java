class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    stack.addLast('(');
                    indexes.addLast(i);
                } else {
                    if (!stack.isEmpty() && stack.peekLast() == '(') {
                        stack.removeLast();
                        indexes.removeLast();
                    } else {
                        stack.addLast(')');
                        indexes.addLast(i);
                    }
                }
            }
        }
        int index = 0;
        while (index < s.length() && !stack.isEmpty() && stack.peekFirst() == ')') {
            if (locked.charAt(index) == '0') {
                if (indexes.peekFirst() > index) {
                    indexes.removeFirst();
                    stack.removeFirst();
                    index++;
                } else {
                    return false;
                }
            } else {
                index++;
            }
        }
        if (stack.isEmpty()) return true;
        index = s.length() - 1;
        while (index >= 0 && !stack.isEmpty() && stack.peekLast() == '(') {
            if (locked.charAt(index) == '0') {
                if (indexes.peekLast() < index) {
                    indexes.removeLast();
                    stack.removeLast();
                    index--;
                } else {
                    return false;
                }
            } else {
                index--;
            }
        }
        return stack.isEmpty();
    }
}