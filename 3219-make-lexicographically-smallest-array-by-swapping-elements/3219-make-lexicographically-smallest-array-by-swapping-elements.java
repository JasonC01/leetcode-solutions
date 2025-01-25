class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{nums[i], i});
        }
        arr.sort(Comparator.comparing(x -> x[0]));
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length;) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            curr.add(arr.get(i)[0]);
            indexes.add(arr.get(i)[1]);
            i++;
            while (i < nums.length && arr.get(i)[0] - curr.get(curr.size() - 1) <= limit) {
                curr.add(arr.get(i)[0]);
                indexes.add(arr.get(i)[1]);
                i++;
            }
            indexes.sort(Comparator.comparing(x -> x));
            for (int j = 0; j < curr.size(); j++) {
                ans[indexes.get(j)] = curr.get(j);
            }
        }
        return ans;
    }
}