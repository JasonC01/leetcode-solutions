class Solution {
    int mod = (int) (1e9 + 7);

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[101][201];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        return helper(locations, start, finish, fuel, memo);
    }

    public int helper(int[] locations, int currentLocation, int finish, int fuel, int[][] memo) {
        int ans = 0;
        if (fuel < 0) {
            return 0;
        }
        
        if (memo[currentLocation][fuel] != -1) {
            return memo[currentLocation][fuel];
        }
        if (currentLocation == finish) {
            ans++;
        }
        for (int i = 0; i < locations.length; i++) {
            if (i == currentLocation) {
            } else {
                int fuelCost = Math.abs(locations[i] - locations[currentLocation]);
                ans = (ans + helper(locations, i, finish, fuel - fuelCost, memo)) % mod;
            }
        }
        return memo[currentLocation][fuel] = ans;
    }
}