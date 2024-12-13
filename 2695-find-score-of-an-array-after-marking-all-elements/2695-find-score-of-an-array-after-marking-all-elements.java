class Solution {
    public long findScore(int[] nums) {
        List<int[]> arr = new ArrayList<>();
        HashSet<Integer> marked = new HashSet<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{nums[i], i});
        }
        arr.sort(Comparator.comparing(x -> x[1]));
        arr.sort(Comparator.comparing(x -> x[0]));
        for (int[] i : arr) {
            if (!marked.contains(i[1])) {
                ans += i[0];
                marked.add(i[1]);
                marked.add(i[1] + 1);
                marked.add(i[1] - 1);
            }
        }
        return ans;
    }
}