class Solution {
    int mod = (int) (1e9 + 7);
    long[][] memo;
    public int lengthAfterTransformations(String s, int t) {
        memo = new long[26][t + 1];
        long ans = 0;
        for (char c : s.toCharArray()) {
            ans = (ans + transform(c, t)) % mod;
        }
        return (int) ans;
    }

    public long transform(char c, int t) {
        int distanceToZ = 'z' - c;
        if (t <= distanceToZ) {
            return 1;
        } else {
            if (memo[c - 'a'][t] != 0) return memo[c - 'a'][t];
            long first = transform('a', t - distanceToZ - 1);
            long second = transform('b', t - distanceToZ - 1);
            memo[c - 'a'][t] = (first + second) % mod;
            return memo[c - 'a'][t];
        }
//        return power((int) Math.ceil((t - distanceToZ) / 26.0));
    }
}