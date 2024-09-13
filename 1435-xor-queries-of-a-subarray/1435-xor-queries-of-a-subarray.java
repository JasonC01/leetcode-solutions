class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefXor = new int[arr.length];
        prefXor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefXor[i] = prefXor[i - 1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int[] query = queries[i];
            ans[i] = query[0] == 0 ? prefXor[query[1]] : prefXor[query[1]] ^ prefXor[query[0] - 1];
        }
        return ans;
    }
}