class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(new ArrayList<>(), new HashSet<>(), nums);
    }

    public List<List<Integer>> helper(List<Integer> res, HashSet<Integer> container, int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return ans;
        }
        for (Integer i : nums) {
            if (!container.contains(i)) {
                container.add(i);
                res.add(i);
                ans.addAll(helper(res, container, nums));
                container.remove(i);
                res.remove(i);
            }
        }
        return ans;
    }

}