class Solution {
     public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        int[][] newIntervals = new int[intervals.length + 1][2];
        int index = 0;
        boolean added = false;
        for (int i = 0; i <= intervals.length; i++) {
            if (index > intervals.length - 1 || (newInterval[0] <= intervals[index][0] && !added)) {
                added = true;
                newIntervals[i] = newInterval;
            } else {
                newIntervals[i] = intervals[index++];
            }
        }
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : newIntervals) {
            if (stack.isEmpty()) stack.push(interval);
            else {
                if (stack.peek()[1] >= interval[0]) {
                    stack.peek()[1] = Math.max(stack.peek()[1], interval[1]);
                } else {
                    stack.push(interval);
                }
            }
        }
        int[][] ans = new int[stack.size()][2];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }
}