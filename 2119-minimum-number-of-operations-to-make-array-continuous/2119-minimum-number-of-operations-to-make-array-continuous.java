class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                duplicates.add(i);
            } else {
                set.add(i);
            }
        }
        int index = 0;
        int[] nums2 = new int[set.size()];
        for (int i : set) {
            nums2[index++] = i;
        }
        Arrays.sort(nums2);
        int low = 0;
        int high = 0;
        int maxDiff = nums.length - 1;
        int maxLow = 0;
        int maxHigh = 0;
        while (high < nums2.length) {
            if (nums2[high] - nums2[low] > maxDiff) {
                if (high - low > maxHigh - maxLow) {
                    maxHigh = high;
                    maxLow = low;
                }
                while (nums2[high] - nums2[low] > maxDiff) {
                    low++;
                }
            }
            high++;
        }
        if (high - low > maxHigh - maxLow) {
            maxHigh = high;
            maxLow = low;
        }
        int maxLen = maxHigh - maxLow;
        maxLen = Math.max(maxLen, high - low);
        int duplicate = nums.length - set.size();
//        int inDuplicate = 0;
//        for (int i = maxLow; i < maxHigh; i++) {
//            if (duplicates.contains(nums2[i])) {
//                inDuplicate++;
//            }
//        }
        return nums.length - maxLen;
    }
}