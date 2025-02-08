class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0, new ArrayList<>());
    }
    
    public List<List<Integer>> helper(int[] nums, int index, List<Integer> res) {
        List<List<Integer>> ans = new ArrayList<>();
        if (index > nums.length - 1) {
            ans.add(new ArrayList<>(res));
            return ans;
        }
        ans.addAll(helper(nums, index + 1, res));
        res.add(nums[index]);
        ans.addAll(helper(nums, index + 1, res));
        res.remove(res.size() - 1);
        return ans;
    }
}