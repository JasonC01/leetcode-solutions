class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        char prev = '-';
        int prevCount = 0;
        int index = 0;
        while (index < sb.length()) {
            if (sb.charAt(index) != prev) {
                prev = sb.charAt(index);
                prevCount = 1;
                index++;
            } else {
                if (prevCount == 2) {
                    sb.deleteCharAt(index);
                } else {
                    prevCount += 1;
                    index++;
                }
            }
        }
        return sb.toString();
    }
}