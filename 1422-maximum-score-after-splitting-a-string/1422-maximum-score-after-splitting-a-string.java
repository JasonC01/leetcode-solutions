class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        zeros[0] = s.charAt(0) == '0' ? 1 : 0;
        ones[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros[i] = zeros[i - 1] + 1;
            } else {
                zeros[i] = zeros[i - 1];
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ones[i] = ones[i + 1] + 1;
            } else {
                ones[i] = ones[i + 1];
            }
        }
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, zeros[i] + ones[i + 1]);
        }
        
        return max;
    }
}