class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        }
        int low = k < 0 ? k - 1 : 0;
        int high = Math.max(k + 1, 0);
        int currentSum = 0;
        for (int i = low + 1; i < high; i++) {
            currentSum += code[(code.length + i) % code.length];
        }
        for (int i = 0; i < code.length; i++) {
            ans[i] = currentSum;
            currentSum = currentSum - code[(code.length + ++low) % code.length] + code[(code.length + high++) % code.length];
        }
        return ans;
    }
}