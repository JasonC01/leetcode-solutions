class Solution {
    int[] d = new int[]{1, 7, 30};
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[400];
        Arrays.fill(memo, -1);
        return helper(days, costs, 0, 0);
    }

    public int helper(int[] days, int[] costs, int index, int currentDay) {
        if (index > days.length - 1) {
            return 0;
        }
        if (memo[currentDay] != -1) {
            return memo[currentDay];
        }
        int ans = Integer.MAX_VALUE;
        if (days[index] <= currentDay) {
            ans = helper(days, costs, index + 1, currentDay);
        } else {
            for (int i = 0; i < costs.length; i++) {
                ans = Math.min(ans, costs[i] + helper(days, costs, index + 1, days[index] + d[i] - 1));
            }
        }
        memo[currentDay] = ans;
        return ans;
    }
}