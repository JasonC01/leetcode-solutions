class Solution {
    public long minCost(int[] nums, int[] cost) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        List<int[]> arr = new ArrayList<>();
        long[] prefixSum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{nums[i], cost[i]});
        }
        arr.sort(Comparator.comparing(x -> x[0]));
        prefixSum[0] = arr.get(0)[1];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += arr.get(i)[1] + prefixSum[i - 1];
        }
        long total = 0;
        for (int[] x : arr) {
            total += (long) (x[0] - arr.get(0)[0]) * x[1];
        }
        long ans = total;
        for (int x = 1; x < arr.size(); x++) {
            total += (long) (prefixSum[x - 1]) * (arr.get(x)[0] - arr.get(x - 1)[0]);
            total -= (long) (prefixSum[arr.size() - 1] - prefixSum[x - 1]) * (arr.get(x)[0] - arr.get(x - 1)[0]);
            ans = Math.min(total, ans);
        }
        return ans;
    }
}