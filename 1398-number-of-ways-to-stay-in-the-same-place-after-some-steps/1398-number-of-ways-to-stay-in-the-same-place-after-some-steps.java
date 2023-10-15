class Solution {
    int mod = (int) (1e9 + 7);
    HashMap<Integer, HashMap<Integer, Integer>> memo;
    public int numWays(int steps, int arrLen) {
        memo = new HashMap<>();
        return helper(steps, arrLen, 0);
    }

    public int helper(int remainingSteps, int arrLen, int index) {
        if (index < 0 || index > arrLen - 1) {
            return 0;
        }
        if (remainingSteps == 0) {
            return index == 0 ? 1 : 0;
        }
        if (!memo.containsKey(remainingSteps)) {
            memo.put(remainingSteps, new HashMap<>());
        }
        if (memo.get(remainingSteps).containsKey(index)) {
            return memo.get(remainingSteps).get(index);
        }
        int ans = helper(remainingSteps - 1, arrLen, index - 1);
        ans = (ans + helper(remainingSteps - 1, arrLen, index)) % mod;
        ans = (ans + helper(remainingSteps - 1, arrLen, index + 1)) % mod;
        memo.get(remainingSteps).put(index, ans);
        return ans;
    }
}