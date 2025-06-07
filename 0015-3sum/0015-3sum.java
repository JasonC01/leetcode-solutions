class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> res = new ArrayList<>();
            int low = i + 1;
            int high = nums.length - 1;
            int target = -nums[i];
            
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    res.add(nums[i]);
                    res.add(nums[low]);
                    res.add(nums[high]);
                    set.add(res);
                    res = new ArrayList<>();
                     low++;
                     high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}