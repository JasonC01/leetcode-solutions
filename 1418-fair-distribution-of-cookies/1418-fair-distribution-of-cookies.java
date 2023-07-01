class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return helper(cookies, new int[k], 0);
    }

    public int helper(int[] cookies, int[] distribution, int index) {
        if (index > cookies.length - 1) {
            int ans = 0;
            for (int i : distribution) {
                ans = Math.max(i, ans);
            }
            return ans;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < distribution.length; i++) {
            distribution[i] += cookies[index];
            ans = Math.min(ans, helper(cookies, distribution, index + 1));
            distribution[i] -= cookies[index];
        }
        return ans;
    }
}