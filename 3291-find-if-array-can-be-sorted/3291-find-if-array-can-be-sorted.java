class Solution {
    public boolean canSortArray(int[] nums) {
        int[] setBits = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            setBits[i] = getSetBits(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] > nums[j]) {
                    if (setBits[j - 1] == setBits[j]) {
                        int temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int getSetBits(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 2;
            x /= 2;
        }
        return ans;
    }
}