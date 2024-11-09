class Solution {
    public long minEnd(int n, int x) {
        long curr = x;
        for (int i = 1; i < n; i++) {
            curr = (curr + 1) | x;
        }
        return curr;
    }
}