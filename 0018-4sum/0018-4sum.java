class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long currTarget = (long) target - (long) nums[i] - (long) nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    long currSum = (long) nums[low] + (long) nums[high];
                    if (currSum == currTarget) {
                        List<Integer> currArr = new ArrayList<>();
                        currArr.add(nums[i]);
                        currArr.add(nums[j]);
                        currArr.add(nums[low]);
                        currArr.add(nums[high]);
                        res.add(currArr);
                        high--;
                        low++;
                    } else if (currSum < currTarget) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}