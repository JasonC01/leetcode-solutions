class Solution {
    long[][] memo;
    public int paintWalls(int[] cost, int[] time) {
        int totalCost = 0;
        for (int i : cost) {
            totalCost += i;
        }
        memo = new long[cost.length][501];
        int[][] work = new int[cost.length][2];
        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
            work[i] = new int[]{cost[i], time[i]};
        }

        Arrays.sort(work, Comparator.comparing(x -> x[0]));
        return (int) helper(work, 0, 0, 0);
    }

    public long helper(int[][] work, int index, int completedJobs, int totalCost) {
        if (completedJobs >= work.length) {
            return totalCost;
        }
        if (index > work.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (memo[index][completedJobs] != Integer.MAX_VALUE) {
            return memo[index][completedJobs] + totalCost;
        }
        memo[index][completedJobs] = Math.min(helper(work, index + 1, completedJobs + work[index][1] + 1, totalCost + work[index][0]),
                helper(work, index + 1, completedJobs, totalCost)) - totalCost;
        return memo[index][completedJobs] + totalCost;
    }
}