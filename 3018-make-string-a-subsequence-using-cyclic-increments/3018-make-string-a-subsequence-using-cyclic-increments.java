class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length() && i2 < str2.length()) {
            if (str1.charAt(i1) == str2.charAt(i2) || str2.charAt(i2) - 97 == (str1.charAt(i1) + 1 - 97) % 26) {
                i2++;
            }
            i1++;
        }
        return i2 == str2.length();
    }
}