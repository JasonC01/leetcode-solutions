class Solution {
    double ans = 0;
    double[][] memo;
    public double soupServings(int n) {
        if (n > 4800) {
            return 1;
        }
        memo = new double[n + 1][n + 1];
        helper(n, n,1);

        return ans;
    }

    public double helper(int soupA, int soupB, double prob) {
        if (soupA == 0 && soupB == 0) {
            ans += prob / 2;
            return prob / 2;
        } else if (soupA == 0) {
            ans += prob;
            return prob;
        } else if (soupB == 0) {
            return 0;
        }
        else {
            if (memo[soupA][soupB] != 0) {
                ans += memo[soupA][soupB];
                return memo[soupA][soupB];
            }
            double res = helper(Math.max(0, soupA - 100), soupB,prob * 0.25) +
            helper(Math.max(0, soupA - 75), Math.max(0, soupB - 25), prob * 0.25) +
            helper(Math.max(0, soupA - 50), Math.max(0, soupB - 50),prob * 0.25) +
            helper(Math.max(0, soupA - 25), Math.max(0, soupB - 75),prob * 0.25);
            memo[soupA][soupB] = res;
            return res;
        }
    }
}