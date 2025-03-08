class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') blackCount++;
        }
        if (blackCount == k) {
            return 0;
        }
        int ans = k - blackCount;
        for (int i = k; i < blocks.length(); i++) {
            blackCount -= blocks.charAt(i - k) == 'B' ? 1 : 0;
            blackCount += blocks.charAt(i) == 'B' ? 1 : 0;
            ans = Math.min(ans, k - blackCount);
        }
        return ans;
    }

}