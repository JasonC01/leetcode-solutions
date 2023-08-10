class Solution {
   public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target || nums[low] == target || nums[high] == target) {
                return true;
            }

            if (target > nums[mid] && target < nums[high]) {
                low = mid + 1;
            } else if (target < nums[mid] && target > nums[low]) {
                high = mid - 1;
            } else {
                low++;
                high--;
            }
        }
        return false;
    }
}