class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int high = nums[nums.length - 1] - nums[0];
        int low = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            if (count(nums, mid) >= p) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int count(int[] nums, int target) {
        int index = 0;
        int count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= target) {
                index++;
                count++;
            }
            index++;
        }
        return count;
    }
}