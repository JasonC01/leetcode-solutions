class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i : rolls) {
            sum += i;
        }
        int rem = (mean * (n + rolls.length)) - sum;
        if (rem > 6 * n || rem < 1 * n) {
            return new int[]{};
        }
        int[] ans = new int[n];
        int remainder = rem % n;
        int val = (rem - remainder) / n;
        for (int i = 0; i < n; i++) {
            ans[i] = val + (remainder > 0 ? 1 : 0);
            remainder--;
        }
        return ans;
    }
}