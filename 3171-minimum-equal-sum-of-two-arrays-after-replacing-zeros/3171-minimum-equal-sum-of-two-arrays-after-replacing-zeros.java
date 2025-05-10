class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long firstSum = 0;
        int firstZero = 0;
        long secondSum = 0;
        int secondZero = 0;
        for (int i : nums1) {
            firstSum += i;
            if (i == 0) firstZero++;
        }
        for (int i : nums2) {
            secondSum += i;
            if (i == 0) secondZero++;
        }
        if (firstZero > 0 && secondZero > 0) {
            return Math.max(firstSum + firstZero, secondSum + secondZero);
        } else if (firstZero > 0) {
            if (firstSum + firstZero <= secondSum) return secondSum;
        } else if (secondZero > 0) {
            if (secondSum + secondZero <= firstSum) return firstSum;
        } else {
            if (firstSum == secondSum) return firstSum;
        }
        return -1;
    }
}