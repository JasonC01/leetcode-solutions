class Solution {
     public int maxArea(int[] height) {
        int high = height.length - 1;
        int low = 0;
        int max = 0;
        while (low < high) {
            max = Math.max((high - low) * Math.min(height[high], height[low]), max);
            if (height[high] < height[low]) {
                high--;
            } else {
                low++;
            }
        }
        return max;
    }
}