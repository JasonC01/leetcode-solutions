class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> schedules = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            schedules.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        schedules.sort(Comparator.comparing(x -> x[0]));
        int[] memo = new int[schedules.size()];
        memo[schedules.size() - 1] = schedules.get(schedules.size() - 1)[2];
        for (int i = schedules.size() - 2; i >= 0; i--) {
            int next = bSearch(schedules, schedules.get(i)[1]);
            if (next != -1) {
                memo[i] = Math.max(schedules.get(i)[2] + memo[next], memo[i + 1]);
            } else {
                memo[i] = Math.max(schedules.get(i)[2], memo[i + 1]);
            }
        }
        return memo[0];
    }

    public int bSearch(List<int[]> schedules, int minTime) {
        int low = 0;
        int high = schedules.size() - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (schedules.get(mid)[0] >= minTime) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return schedules.get(low)[0] >= minTime ? low : -1;
    }
}