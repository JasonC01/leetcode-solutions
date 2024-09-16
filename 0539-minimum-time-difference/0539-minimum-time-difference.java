class Solution {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(Comparator.comparing(x -> x.split(":")[1]));
        timePoints.sort(Comparator.comparing(x -> x.split(":")[0]));
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String curr = timePoints.get(i);
            String next = timePoints.get(i + 1);
            ans = Math.min(getTimeDiff(curr, next, false), ans);
        }
        String curr = timePoints.get(timePoints.size() - 1);
        String next = timePoints.get(0);
        ans = Math.min(getTimeDiff(curr, next, true), ans);
        return ans;
    }

    public int getTimeDiff(String t1, String t2, boolean isEnd) {
        int h1 = Integer.parseInt(t1.split(":")[0]);
        int m1 = Integer.parseInt(t1.split(":")[1]);
        int h2 = Integer.parseInt(t2.split(":")[0]);
        int m2 = Integer.parseInt(t2.split(":")[1]);
        int hDiff = isEnd ? 24 - Math.abs(h2 - h1) : h2 - h1;
        return (hDiff * 60) - m1 + m2;
    }

}