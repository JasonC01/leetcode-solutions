class Solution {
    int mod = (int) (1e9 + 7);
    public int numOfSubarrays(int[] arr) {
        int[] pref = new int[arr.length];
        int[] oddCount = new int[arr.length];
        int[] evenCount = new int[arr.length];
        pref[0] = arr[0];
        oddCount[0] = 0;
        evenCount[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            pref[i] = arr[i] + pref[i - 1];
            oddCount[i] = (pref[i - 1] % 2 == 0 ? 0 : 1) + oddCount[i - 1];
            evenCount[i] = (pref[i - 1] % 2 == 0 ? 1: 0) + evenCount[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pref[i] % 2 == 1) {
                ans = (ans + 1 + evenCount[i]) % mod;
            } else {
                ans = (ans + oddCount[i]) % mod;
            }
        }
        return ans;
    }
}

// 1 4 9
// 0 1 1 oddcount
// 0 0 1 evencount