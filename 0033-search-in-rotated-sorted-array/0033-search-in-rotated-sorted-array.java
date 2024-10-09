class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            System.out.println(low);
            System.out.println(high);
            int mid = Math.floorDiv(low + high, 2);
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > nums[high]) {
                    if (nums[mid] > target) {
                        if (nums[low] > target) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }

                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (nums[mid] > target) {
                        high = mid - 1;
                    } else {
                        if (nums[high] >= target) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
}