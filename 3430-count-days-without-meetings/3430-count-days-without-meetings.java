class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparing(x -> x[0]));
        int prevEnd = 0;
        int ans = 0;
        for (int i = 0; i < meetings.length; i++) {
            int currStart = meetings[i][0];
            int currEnd = meetings[i][1];
            ans += Math.max(0, currStart - prevEnd - 1);
            prevEnd = Math.max(prevEnd, currEnd);
        }
        return ans + (days - prevEnd);
    }
}