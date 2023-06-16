class Solution {
    public long mod = (long) (1e9 + 7);
    public long[][] table;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        table = new long[m][m];
        for (int i = 0; i < m; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
        return (int) ((int) (numOfWays2(nums) - 1) % mod);
    }
    public long numOfWays2(int[] nums) {
        int m = nums.length;
        if (nums.length <= 2) {
            return 1;
        }
        int root = nums[0];
        int lessCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                lessCount++;
            }
        }
        int[] less = new int[lessCount];
        int[] more = new int[nums.length - 1 - lessCount];
        int lessIndex = 0;
        int moreIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                less[lessIndex++] = nums[i];
            } else {
                more[moreIndex++] = nums[i];
            }
        }
        long left = numOfWays2(less) % mod;
        long right = numOfWays2(more) % mod;
        return ((long) (table[m - 1][lessCount] * ((left * right) % mod)) % mod);
    }
}