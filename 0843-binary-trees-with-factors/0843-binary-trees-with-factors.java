class Solution {
    int mod = (int) (1e9 + 7);
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] memo = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        for (int i : arr) {
            long res = 1;
            for (int j : arr) {
                 if (i % j == 0) {
                     if (map.containsKey(i / j)) {
                         res = (res + ((long) (memo[map.get(i / j)] % mod) * (memo[map.get(j)] % mod))) % mod;
                     }
                 }
            }
            memo[map.get(i)] = (int) res;
        }
        int ans = 0;
        for (int i : memo) {
            ans = (ans + i) % mod;
        }
        return ans;
    }

}