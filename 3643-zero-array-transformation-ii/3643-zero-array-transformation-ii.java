class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int low = 0;
        int high = queries.length;
        boolean allZero = true;
        for (int i : nums) {
            allZero &= (i == 0);
        }
        if (allZero) return 0;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (isPossible(nums, queries, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return isPossible(nums, queries, low) ? low: -1;
    }

    public boolean isPossible(int[] nums, int[][] queries, int index) {
        int[] da = new int[nums.length + 1];
        for (int i = 0; i < index; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int val = queries[i][2];
            da[from] += val;
            da[to + 1] -= val;
        }
        for (int i = 1; i < da.length; i++) {
            da[i] += da[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > da[i]) {
                return false;
            }
        }
        return true;
    }
}