class Solution {
    public boolean increasingTriplet(int[] nums) {
        return lis(nums) >= 3;
    }

    public int lis(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int ans = 0;
        for (int i : nums) {
            int index = binarySearch(arr, i);
            arr[index] = i;
            ans = Math.max(ans, index + 1);
        }
        return ans;
    }

    public int binarySearch(int[] arr, int i) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (int) Math.floor((double) (low + high) / 2);
            if (arr[mid] >= i) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}