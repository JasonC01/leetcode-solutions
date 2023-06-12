class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int start = 0;
        int end = 0;
        int curr = nums[end];
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr + 1) {
                end++;
            } else {
                if (start == end) {
                    ans.add(String.valueOf(curr));
                } else {
                    ans.add(nums[start] + "->" + nums[end]);
                }
                start = i;
                end = i;
            }
            curr = nums[i];
        }
        if (start == end) {
                    ans.add(String.valueOf(curr));
                } else {
                    ans.add(nums[start] + "->" + nums[end]);
                }
        return ans;
    }
}