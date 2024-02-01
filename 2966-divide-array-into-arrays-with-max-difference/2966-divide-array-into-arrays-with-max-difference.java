class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (curr.size() < 3) {
                if (nums[i] - curr.get(0) <= k) {
                    curr.add(nums[i]);
                } else {
                    return new int[][]{};
                }
            } else {
                res.add(new ArrayList<>(curr));
                curr.clear();
                curr.add(nums[i]);
            }
        }
        res.add(new ArrayList<>(curr));
        int[][] ans = new int[res.size()][3];
        int index = 0;
        for (List<Integer> arr : res) {
            int[] a = new int[3];
            for (int i = 0; i < 3; i++) {
                a[i] = arr.get(i);
            }
            ans[index++] = a;
        }
        return ans;
    }
}