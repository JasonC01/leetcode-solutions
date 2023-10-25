class Solution {
    public int kthGrammar(int n, int k) {
        return helper(n - 1, k - 1, 0);
    }

    public int helper(int n, int k, int value) {
        if (n == 0 && k == 0) {
            return value;
        }
        if (Math.pow(2, n - 1) - 1 >= k) {
            if (value == 0) {
                return helper(n - 1, k, 0);
            } else {
                return helper(n - 1, k, 1);
            }
        } else {
            if (value == 0) {
                return helper(n - 1, (int) (k - Math.pow(2, n - 1)), 1);
            } else {
                return helper(n - 1, (int) (k - Math.pow(2, n - 1)), 0);
            }
        }
    }

}