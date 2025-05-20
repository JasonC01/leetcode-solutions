class Solution {
     public int maxCoins(int[] nums) {
        List<int[]> arrs = new ArrayList<>();
        arrs.add(new int[]{1, nums[0]});
        for (int i = 0; i < nums.length - 1; i++) {
            arrs.add(new int[]{nums[i], nums[i + 1]});
        }
        arrs.add(new int[]{nums[nums.length - 1], 1});
        int[][] dp = new int[arrs.size()][arrs.size()];
        for (int length = 2; length <= arrs.size(); length++) {
            for (int start = 0; start <= arrs.size() - length; start++) {
                int end = start + length - 1;
                dp[start][end] = Integer.MIN_VALUE;
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][k] + dp[k + 1][end] + (arrs.get(start)[0] * arrs.get(k)[1] * arrs.get(end)[1]));
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][arrs.size() - 1];
    }
}