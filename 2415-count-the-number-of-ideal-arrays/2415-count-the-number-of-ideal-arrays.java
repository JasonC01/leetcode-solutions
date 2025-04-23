class Solution {
    int mod = (int) (1e9 + 7);
    public int idealArrays(int n, int maxValue) {
        int[] sieve = new int[maxValue + 1];
        List<Integer>[] pf = new List[maxValue + 1];
        int[][] comb = new int[n + 15][16];
        for (int i = 0; i < pf.length; i++) {
            pf[i] = new ArrayList<>();
        }
        for (int i = 2; i <= maxValue; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j <= maxValue; j += i) {
                    if (sieve[j] == 0) sieve[j] = i;
                }
            }
        }
        // System.out.println(Arrays.toString(sieve));

        for (int i = 1; i <= maxValue; i++) {
            int x = i;
            
            while (x > 1) {
                int div = sieve[x];
                int count = 0;
                while ((x % div) == 0) {
                    x /= div;
                    count++;
                }
                pf[i].add(count);
            }
        }
        comb[0][0] = 1;
        for (int i = 1; i < n + 15; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 15); j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
            }
        }
        long ans = 0;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1;
            for (int p : pf[x]) {
                mul = (mul * (long) comb[n + p - 1][p]) % mod;
            }
            ans = (ans + mul) % mod;
        }
        return (int) ans;
    }
}