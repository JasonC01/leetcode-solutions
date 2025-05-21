class Solution {
    int mod = (int) (1e9 + 7);
    public int countPalindromes(String s) {
        int ans = 0;
        int[][][] suf = new int[s.length() + 1][10][10]; //dp[i][j][k] = number of (i, j) pairs starting from index k (inclusive)
        int[][][] pref = new int[s.length() + 1][10][10];
        HashMap<Integer, Integer> sufCounter = new HashMap<>();
        HashMap<Integer, Integer> prefCounter = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            int currKey = Integer.parseInt(s.substring(i, i + 1));
            for (int key : sufCounter.keySet()) {
                suf[i][currKey][key] += sufCounter.get(key);
            }
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    suf[i][j][k] += suf[i + 1][j][k];
                }
            }
            sufCounter.merge(currKey, 1, (a, b) -> a + 1);
        }
        prefCounter.put(Integer.parseInt(s.substring(0, 1)), 1);
        for (int i = 1; i < s.length(); i++) {
            int currKey = Integer.parseInt(s.substring(i, i + 1));
            for (int key : prefCounter.keySet()) {
                pref[i][currKey][key] += prefCounter.get(key);
            }
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    pref[i][j][k] += pref[i - 1][j][k];
                }
            }
            prefCounter.merge(currKey, 1, (a, b) -> a + 1);
        }
        for (int i = 2; i < s.length() - 2; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans = (int) (ans + (1L * pref[i - 1][j][k] * suf[i + 1][j][k]) % mod) % mod;
                }
            }
            
        }
        return ans;
    }
}