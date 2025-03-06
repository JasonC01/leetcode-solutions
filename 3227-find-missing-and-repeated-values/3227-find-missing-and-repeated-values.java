class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int[] i : grid) {
            for (int j : i) {
                if (set.contains(j)) {
                    ans[0] = j;
                } else {
                    set.add(j);
                }
            }
        }
        for (int i = 1; i <= Math.pow(grid.length, 2); i++) {
            if (!set.contains(i)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}