class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, 0, target, new ArrayList<>());
    }

    public List<List<Integer>> helper(int[] candidates, int index, int target, List<Integer> res) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(res);
            return ans;
        }
        if (index > candidates.length - 1) {
            return ans;
        }
        int remaining = target;
        int curr = candidates[index];
        ans.addAll(helper(candidates, index + 1, target, new ArrayList<>(res)));
        while (remaining >= curr) {
            res.add(curr);
            ans.addAll(helper(candidates, index + 1, remaining - curr, new ArrayList<>(res)));
            remaining -= curr;
        }
        return ans;
    }
}