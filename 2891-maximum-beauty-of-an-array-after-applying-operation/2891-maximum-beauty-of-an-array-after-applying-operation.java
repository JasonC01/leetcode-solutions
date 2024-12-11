class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(new int[]{i - k, 1});
            arr.add(new int[]{i + k, -1});
        }
        arr.sort((a, b) -> Integer.compare(b[1], a[1]));
        arr.sort(Comparator.comparing(x -> x[0]));
        int ans = 0;
        int count = 0;
        for (int[] i : arr) {
            count += i[1];
            ans = Math.max(ans, count);
        }
        return ans;
    }
}