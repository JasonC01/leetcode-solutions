class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(i);
        }
        return helper(arr, new ArrayList<>());
    }
    
    public List<List<Integer>> helper(List<Integer> nums, List<Integer> curr) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.isEmpty()) {
            ans.add(curr);
            return ans;
        }
        for (int i : nums) {
            List<Integer> a = new ArrayList<>(nums);
            List<Integer> b = new ArrayList<>(curr);
            b.add(i);
            a.remove((Integer) i);
            ans.addAll(helper(a, b));
        }
        return ans;
    }
}