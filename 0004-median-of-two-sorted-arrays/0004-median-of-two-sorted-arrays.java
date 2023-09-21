class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (double) (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        } else if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (double) (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        List<Integer> targetIndex = new ArrayList<>();
        int totalLength = nums1.length + nums2.length;
        targetIndex.add(totalLength / 2);
        if (totalLength % 2 == 0) {
            targetIndex.add((totalLength / 2) - 1);
        }
        double ans = helper(nums1, nums2, targetIndex);
        ans += helper(nums2, nums1, targetIndex);
        if (!targetIndex.isEmpty()) {
            ans += helper2(nums1, nums2, targetIndex);
            ans += helper2(nums2, nums1, targetIndex);
        }
        return totalLength % 2 == 0 ? ans / 2 : ans;
    }

    public double helper(int[] nums1, int[] nums2, List<Integer> targetIndex) {
        HashSet<Integer> toRemove = new HashSet<>();
        int sum = 0;
        for (int index : targetIndex) {
            int high = nums1.length - 1;
            int low = 0;
            boolean added = false;
            while (low < high) {
                int mid = (low + high) / 2;
                int idx = binarySearch(nums2, nums1[mid]);
                if (idx + mid == index) {
                    sum += nums1[mid];
                    added = true;
                    toRemove.add(index);
                    break;
                }
                if (idx + mid < index) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int idx = binarySearch(nums2, nums1[low]) + low;
            if (idx == index) {
                if (!added) {
                    sum += nums1[low];
                    toRemove.add(index);
                }
            }
        }
        targetIndex.removeAll(toRemove);
        return sum;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            if (arr[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return arr[low] <= target ? low + 1 : 0;
    }

    public double helper2(int[] nums1, int[] nums2, List<Integer> targetIndex) {
        HashSet<Integer> toRemove = new HashSet<>();
        int sum = 0;
        for (int index : targetIndex) {
            int high = nums1.length - 1;
            int low = 0;
            boolean added = false;
            while (low < high) {
                int mid = (low + high) / 2;
                int idx = binarySearch2(nums2, nums1[mid]);
                if (idx + mid == index) {
                    sum += nums1[mid];
                    added = true;
                    toRemove.add(index);
                    break;
                }
                if (idx + mid < index) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int idx = binarySearch2(nums2, nums1[low]) + low;
            if (idx == index) {
                if (!added) {
                    sum += nums1[low];
                    toRemove.add(index);
                }
            }
        }
        targetIndex.removeAll(toRemove);
        return sum;
    }

    public int binarySearch2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            if (arr[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return arr[low] < target ? low + 1 : 0;
    }
}