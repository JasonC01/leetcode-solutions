class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        ones[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            zeros[i] = zeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            ones[s.length() - 1 - i] = ones[s.length() - i] + (s.charAt(s.length() - 1 - i) == '1' ? 1 : 0);
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans = Math.max(ans, zeros[i] + ones[i + 1]);
        }
        return ans;
    }
}