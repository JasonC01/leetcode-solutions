class Solution {
    int mod = (int) 1e9 + 7;
    public int waysToSplit(int[] nums) {
        int[] prefSum = new int[nums.length];
        prefSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }
        // System.out.println(Arrays.toString(prefSum));
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int rIndex = bSearchRight(prefSum, i, nums.length - 2);
            int lIndex = bSearchLeft(prefSum, i, nums.length - 2);
            // System.out.println(Arrays.toString(new int[]{i, lIndex, rIndex}));
            if (rIndex >= lIndex && prefSum[i - 1] <= prefSum[lIndex] - prefSum[i - 1] && prefSum[rIndex] - prefSum[i - 1] <= prefSum[nums.length - 1] - prefSum[rIndex]) {
                // System.out.println("Adding");
                ans = (ans + (rIndex - lIndex + 1)) % mod;
            }
        }
        return ans;
    }

    public int bSearchRight(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        while (l < h) {
            int mid = (int) Math.ceil((l + h) / 2.0);
            int leftSum = arr[low - 1];
            int midSum = arr[mid] - leftSum;
            int rightSum = arr[arr.length - 1] - arr[mid];
            if (rightSum < midSum) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public int bSearchLeft(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        while (l < h) {
            int mid = Math.floorDiv(l + h, 2);
            int leftSum = arr[low - 1];
            int midSum = arr[mid] - leftSum;
            if (leftSum <= midSum) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}