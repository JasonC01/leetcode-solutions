class Solution {
    public int minCapability(int[] nums, int k) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (isPossible(nums, sorted[mid], k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return sorted[low];
    }

    public boolean isPossible(int[] arr, int max, int k) {
        int[] nums = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= max) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != 1 && nums[i] == 1) {
                count++;
            } else if (nums[i - 1] == 1 && nums[i] == 1) {
                nums[i] = 0;
            }
        }
        return count >= k;
    }
}