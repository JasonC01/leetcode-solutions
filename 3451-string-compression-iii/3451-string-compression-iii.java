class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char prev = word.charAt(0);
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c != prev || count == 9) {
                sb.append(count);
                sb.append(prev);
                prev = c;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}