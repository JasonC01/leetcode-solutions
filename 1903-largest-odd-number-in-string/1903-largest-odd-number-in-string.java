class Solution {
    public String largestOddNumber(String num) {
        int idx = 0;
        for (int i = 0; i < num.length(); i++) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 1) {
                idx = i + 1;
            }
        }
        return num.substring(0, idx);
    }
}