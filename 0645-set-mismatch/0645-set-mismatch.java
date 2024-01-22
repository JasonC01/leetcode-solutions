class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (s.contains(i)) {
                ans[0] = i;
            }
            s.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!s.contains(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }
}