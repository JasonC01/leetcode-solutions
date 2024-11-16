class Solution {
    public int maxCoins(int[] nums) {
        int[][] matrices = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                matrices[i] = new int[]{1, nums[i]};
            } else {
                matrices[i] = new int[]{nums[i - 1], nums[i]};
            }
        }
        matrices[matrices.length - 1] = new int[]{nums[nums.length - 1], 1};
        int[][] dp = new int[matrices.length][matrices.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        for (int chain_length = 2; chain_length <= matrices.length; chain_length++) {
            for (int start = 0; start < matrices.length - chain_length + 1; start++) {
                int end = start + chain_length - 1;
                dp[start][end] = Integer.MIN_VALUE;
                for (int split = start; split <= end - 1; split++) {
                    dp[start][end] = Math.max(dp[start][split] + dp[split + 1][end] + matrices[start][0] * matrices[split][1] * matrices[end][1], dp[start][end]); 
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}