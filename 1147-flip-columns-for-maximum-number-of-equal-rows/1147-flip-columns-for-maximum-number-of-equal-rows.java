class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> counter = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            for (int i : row) {
                sb.append(i);
                sb1.append(i ^ 1);
            }
            counter.merge(sb.toString(), 1, (a, b) -> a + 1);
            counter.merge(sb1.toString(), 1, (a, b) -> a + 1);
        }
        int ans = 1;
        for (int val : counter.values()) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

}