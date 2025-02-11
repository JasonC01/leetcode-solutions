class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] closestStart = new int[seats.length];
        int[] closestEnd = new int[seats.length];
        int n = seats.length;
        closestStart[0] = seats[0] == 1 ? 0 : Integer.MAX_VALUE;
        closestEnd[n - 1] = seats[n - 1] == 1 ? 0 : Integer.MAX_VALUE;
        for (int i = 1; i < seats.length; i++) {
            closestStart[i] = seats[i] == 1 ? 0 : closestStart[i - 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : closestStart[i - 1] + 1;
            closestEnd[n - 1 - i] = seats[n - 1 - i] == 1 ? 0 : closestEnd[n - i] == Integer.MAX_VALUE ? Integer.MAX_VALUE : closestEnd[n - i] + 1;
        }
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(closestStart[i], closestEnd[i]));
            }
        }
        return ans;
    }
}