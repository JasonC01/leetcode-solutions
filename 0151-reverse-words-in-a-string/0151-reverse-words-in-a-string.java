class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!sb.isEmpty()) {
                    words.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }
        if (!sb.isEmpty()) {
            words.add(sb.toString());
        }
        StringBuilder ans = new StringBuilder();
        if (words.isEmpty()) {
            return "";
        } else {
            ans.append(words.get(words.size() - 1));
            for (int i = words.size() - 2; i >= 0; i--) {
                ans.append(" ");
                ans.append(words.get(i));
            }
        }
        return ans.toString();
    }
}