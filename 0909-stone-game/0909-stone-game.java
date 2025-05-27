class Solution {
    int[][] memo;
    public boolean stoneGame(int[] piles) {
        int total = 0;
        for (int i : piles) total += i;
        memo = new int[piles.length][piles.length];
        return helper(piles, 0, piles.length - 1, true) > total / 2;
    }

    public int helper(int[] piles, int start, int end, boolean isAlice) {
        if (start == end) return isAlice ? piles[start] : 0;
        if (memo[start][end] != 0) return memo[start][end];
        int takeFromStart = helper(piles, start + 1, end, !isAlice) + piles[start];
        int takeFromEnd = helper(piles, start, end - 1, !isAlice) + piles[end];
        int res = isAlice ? Math.max(takeFromEnd, takeFromStart) : Math.min(takeFromEnd, takeFromStart);
        memo[start][end] = res;
        return res;
    }
}