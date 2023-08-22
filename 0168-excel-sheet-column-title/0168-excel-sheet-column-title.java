class Solution {
    public String convertToTitle(int columnNumber) {
        int curr = columnNumber;
        Stack<Character> s = new Stack<>();
        while (true) {
            System.out.println(curr);
            if (curr <= 26) {
                s.push((char) (curr - 1 + 'A'));
                break;
            }
            if (curr % 26 == 0) {
                s.push('Z');
                curr /= 26;
                curr--;
            } else {
                s.push((char) ((curr % 26) - 1 + 'A'));
                curr /= 26;
            }


        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
}