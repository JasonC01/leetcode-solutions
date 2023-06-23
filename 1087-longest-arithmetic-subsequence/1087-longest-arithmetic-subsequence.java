class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int cd = nums[j] - nums[i];
                dp[i].put(cd, dp[j].getOrDefault(cd, 1) + 1);
                max = Math.max(max, dp[i].get(cd));
            }
        }
        return max;
    }
}