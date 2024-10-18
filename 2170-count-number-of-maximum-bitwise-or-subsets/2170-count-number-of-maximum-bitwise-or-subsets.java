class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> vals = helper(nums, 0, 0);
        int max = 0;
        int count = 0;
        System.out.println(vals);
        for (int i : vals) {
            if (i == 0) {
                continue;
            }
            if (i == max) {
                count++;
            }
            if (i > max) {
                max = i;
                count = 1;
            }
        }
        return count;
    }

    public List<Integer> helper(int[] nums, int index, int curr) {
        List<Integer> ans = new ArrayList<>();
        if (index > nums.length - 1) {
            ans.add(curr);
            return ans;
        }
        ans.addAll(helper(nums, index + 1, curr | nums[index]));
        ans.addAll(helper(nums, index + 1, curr));
        return ans;
    }
}