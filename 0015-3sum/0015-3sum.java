class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int total = nums[low] + nums[high];
                if (total == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[low]);
                    res.add(nums[high]);
                    ans.add(res);
                    low++;
                    high--;
                    while (low < high && nums[low - 1] == nums[low]) low++;
                    while (low < high && nums[high + 1] == nums[high]) high--;
                } else if (total > target) {
                    high--;
                } else {
                    low++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}