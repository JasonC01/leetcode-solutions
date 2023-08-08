class Solution {
    public int search(int[] nums, int target) {
        int low = findStart(nums);
        int high = low + nums.length - 1;
        int n = nums.length;
        while (low < high) {
            int mid = ((low + high) / 2);
            if (nums[mid % n] == target) {
                return mid % n;
            } else if (nums[mid % n] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low % n] == target ? low % n : -1;
    }
    public int findStart(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= nums[low] && nums[mid] >= nums[high]) {
                low = mid + 1;
            } else if (nums[mid] <= nums[low] && nums[mid] <= nums[high]) {
                high = mid;
            } else if (nums[mid] >= nums[low] && nums[mid] <= nums[high]) {
                high = mid - 1;
            }
        }
        return low;
    }

}