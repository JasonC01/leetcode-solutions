class Solution {
    int mod = (int) (1e9 + 7);
    public int numWays(String[] words, String target) {
        HashMap<Character, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            for (String word : words) {
                if (!map.containsKey(word.charAt(i))) {
                    map.put(word.charAt(i), new HashMap<>());
                }
                map.get(word.charAt(i)).merge(i, 1, (a, b) -> a + 1);
            }
        }
        int[][] dp = new int[target.length() + 1][words[0].length() + 1];
        Arrays.fill(dp[dp.length - 1], 1);
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                dp[i][j] = (int) (((dp[i + 1][j + 1] * (long) map.getOrDefault(target.charAt(i), new HashMap<>()).getOrDefault(j, 0)) % mod + (long) dp[i][j + 1]) % mod);
            }
        }
        return dp[0][0];
    }
}