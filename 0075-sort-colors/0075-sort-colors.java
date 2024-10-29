class Solution {
    public void sortColors(int[] nums) {
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (nums[two] != 2) {
                    nums[i] = nums[one];
                    nums[one] = 0;
                } else {
                    int temp = nums[two];
                    nums[two] = nums[one];
                    nums[i] = temp;
                    nums[one] = 0;
                }
                one++;
                two++;
            } else if (nums[i] == 1) {
                int temp = nums[two];
                nums[two] = 1;
                nums[i] = temp;
                two++;
            }
        }
    }
}