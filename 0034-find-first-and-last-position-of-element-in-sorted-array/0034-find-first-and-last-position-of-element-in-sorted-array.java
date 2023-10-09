class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }
    
    public int binarySearch(int[] nums, int target, boolean isLow) {
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            if (isLow) {
                int mid = Math.floorDiv(high + low, 2);
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                int mid = (int) Math.ceil((double) (high + low) / 2);
                if (nums[mid] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
}