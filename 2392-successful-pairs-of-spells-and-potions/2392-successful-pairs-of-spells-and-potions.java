class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int index = 0;
        for (int i : spells) {
            ans[index++] = (potions.length - binarySearch(potions, i, success));
        }
        return ans;
    }

    public int binarySearch(int[] nums, int curr, long success) {
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            long product = (long) nums[mid] * curr;
            if (product < success) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return ((long) nums[low] * curr) >= success ? low : nums.length;
    }
}