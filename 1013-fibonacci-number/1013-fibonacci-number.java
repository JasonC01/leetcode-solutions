class Solution {
     public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int curr = 1;
        int prev = 0;
        for (int i = 2; i <= n; i++) {
            int temp = prev;
            prev = curr;
            curr += temp;
        }
        return curr;
    }
}