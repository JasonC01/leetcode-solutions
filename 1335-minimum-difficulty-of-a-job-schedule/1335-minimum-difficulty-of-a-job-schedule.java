class Solution {
   int[][][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        memo = new int[jobDifficulty.length + 1][d + 1][1001];
        for (int[][] arr : memo) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        int res = helper(jobDifficulty, 0, 0, d, 0);
        return res ==Integer.MAX_VALUE ? -1 : res;
    }

    public int helper(int[] jobDifficulty, int index, int day, int d, int currMax) {
        if (day > d) {
            return Integer.MAX_VALUE;
        }
        if (index > jobDifficulty.length - 1) {
            return day == d ? currMax : Integer.MAX_VALUE;
        }
        if (memo[index][day][currMax] != -1) {
            return memo[index][day][currMax];
        }
        int newMax = Math.max(currMax, jobDifficulty[index]);
        int res1 = helper(jobDifficulty, index + 1, day, d, newMax);
        int res2 = helper(jobDifficulty, index + 1, day + 1, d, 0);
        res2 = res2 == Integer.MAX_VALUE ? res2 : res2 + newMax;

        return memo[index][day][currMax] = Math.min(res1, res2);
    }
}