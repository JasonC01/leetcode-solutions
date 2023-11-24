class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int low = 0;
        for (int i = piles.length - 2; i > low; i -= 2) {
            ans += piles[i];
            low++;
        }
        return ans;
    }
}