class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        Arrays.fill(ans, true);
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2 != 0 && nums[i + 1] % 2 != 0) ||
                    (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0)) {
                arr.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int idx = bSearch(arr, q[0]);
            if (idx >= q[0] && idx < q[1]) {
                ans[i] = false;
            }
        }
        return ans;
    }

    public int bSearch(List<Integer> arr, int target) {
        if (arr.isEmpty()) {
            return -1;
        }
        int low = 0;
        int high = arr.size() - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (arr.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return arr.get(low);
    }
}