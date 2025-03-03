class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int smaller = 0;
        int greater = 0;
        int equal = 0;
        for (int i : nums) {
            if (i < pivot) {
                equal++;
                greater++;
            } else if (i == pivot) {
                greater++;
            }
        }
        int[] arr = new int[nums.length];
        for (int i : nums) {
            if (i < pivot) {
                arr[smaller++] = i;
            } else if (i == pivot) {
                arr[equal++] = i;
            } else {
                arr[greater++] = i;
            }
        }
        return arr;
    }
}