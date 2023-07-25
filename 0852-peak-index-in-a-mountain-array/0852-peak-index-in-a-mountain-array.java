class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (int) Math.ceil((double) (high + low) / 2);
            if (mid == arr.length - 1) {
                low++;
            } else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    high = mid - 1;
                }
            }
        }
        return low;
    }
}