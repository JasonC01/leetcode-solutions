class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] counter = new int[201];
        for (int i : nums) {
            counter[i]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 0; x < counter.length; x++) {
            int i = counter[x];
            for (int j = 0; j < i; j++) {
                if (ans.size() <= j) {
                    ans.add(new ArrayList<>());
                }
                ans.get(j).add(x);
            }
        }
        return ans;
    }
}