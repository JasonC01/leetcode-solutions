class Solution {
    int[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        memo = new int[startTime.length + 1];
        jobs.sort(Comparator.comparing(x -> x[0]));
        return helper(jobs, 0, 0);
    }

    public int helper(List<int[]> jobs, int endTime, int jobIndex) {
        for (int i = jobs.size() - 1; i >= 0; i--) {
            int nextIdx = bSearch(jobs, jobs.get(i)[1], i);
            memo[i] = Math.max(memo[i + 1], jobs.get(i)[2] + memo[nextIdx]);
        }
        return memo[0];
    }

    public int bSearch(List<int[]> jobs, int endTime, int currIndex) {
        int low = currIndex + 1;
        int high = jobs.size();
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (jobs.get(mid)[0] < endTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}