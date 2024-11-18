class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            if (k == 0) {
                ans[i] = 0;
            } else if (k > 0) {
                int sum = 0;
                int curr = i + 1;
                for (int j = 0; j < k; j++) {
                    sum += code[(curr + j) % code.length];
                }
                ans[i] = sum;
            } else {
                int sum = 0;
                int curr = i - 1 < 0 ? code.length - 1 : i - 1;
                for (int j = 0; j < Math.abs(k); j++) {
                    sum += code[(curr - j < 0 ? code.length + (curr - j) : curr - j)];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}