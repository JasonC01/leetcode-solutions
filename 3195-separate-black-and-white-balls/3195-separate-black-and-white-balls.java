class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        int curr = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ans += curr - i;
                curr--;
            }
        }
        return ans;
    }
}