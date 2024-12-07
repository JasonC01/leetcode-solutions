class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 1000000000;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (isPossible(nums, maxOperations, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] nums, int maxOp, int limit) {
        for (int i : nums) {
            if (i > limit) {
                maxOp -= ((int) Math.ceil((double) i / limit)) - 1;
            }
        }
        return maxOp >= 0;
    }
}