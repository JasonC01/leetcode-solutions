class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }
        if (low == arr.length - 1) {
            return 0;
        }
        int ans = Math.min(arr.length - low - 1, high);
        for (int i = 0; i <= low; i++) {
            int start = bSearch(arr, high, arr[i]);
            if (arr[start] >= arr[i]) {
                ans = Math.min(ans, start - i - 1);
            }
        }
        return ans;
    }

    public int bSearch(int[] arr, int l, int target) {
        int low = l;
        int high = arr.length - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}