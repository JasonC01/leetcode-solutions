/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int maxIndex = findMaxIndex(mountainArr);
        int atLow = binarySearch(target, mountainArr, 0, maxIndex, true);
        int atHigh = binarySearch(target, mountainArr, maxIndex, mountainArr.length() - 1, false);
        return atLow == -1 ? atHigh : atLow;
    }
    
    public int binarySearch(int target, MountainArray mountainArray, int low, int high, boolean isLowerSide) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (isLowerSide) {
                int elemAtMid = mountainArray.get(mid);
                if (elemAtMid > target) {
                    high = mid - 1;
                } else if (elemAtMid == target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                int elemAtMid = mountainArray.get(mid);
                if (elemAtMid > target) {
                    low = mid + 1;
                } else if (elemAtMid == target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return mountainArray.get(low) == target ? low : -1;
    }
    
    public int findMaxIndex(MountainArray mountainArray) {
        int high = mountainArray.length();
        int low = 0;
        while (low < high) {
            int mid = (int) Math.ceil((high + low) / 2.0);
            if (mountainArray.get(mid) > mountainArray.get(Math.max(mid - 1, 0))) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}