class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        int curr = 0;
        while (curr < nums.length) {
            start.add(curr);
            while (curr < nums.length - 1 && nums[curr + 1] == nums[curr] + 1) {
                curr++;
            }
            end.add(curr++);
        }
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < start.size(); i++) {
            int s = start.get(i);
            int e = end.get(i);
            for (int j = s; j <= e - k + 1; j++) {
                ans[j] = nums[j + k - 1];
            }
        }
        return ans;
    }

}