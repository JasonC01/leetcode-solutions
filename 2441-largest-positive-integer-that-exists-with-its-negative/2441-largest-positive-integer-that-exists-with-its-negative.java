class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] > 0) {
                break;
            }
            int absLow = Math.abs(nums[low]);
            int h = nums[high];
            if (absLow == h) {
                return h;
            } else if (absLow < h) {
                high--;
            } else {
                low++;
            }
        }
        return -1;
    }
}