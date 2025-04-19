class Solution {
     public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int low = bSearchLower(nums, i + 1, lower, curr);
            int high = bSearchUpper(nums, i + 1, upper, curr);
            if (curr + nums[low] < lower || curr + nums[high] > upper) continue;
            ans += (high - low + 1);
        }
        return ans;
    }
    
    public int bSearchLower(int[] nums, int l, int lower, int curr) {
        int low = l;
        int high = nums.length - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (nums[mid] + curr < lower) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int bSearchUpper(int[] nums, int l, int upper, int curr) {
        int low = l;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (nums[mid] + curr > upper) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }
}


// For each element i in nums:
// Need to find other elements in range [lower - i, upper - i]
// 