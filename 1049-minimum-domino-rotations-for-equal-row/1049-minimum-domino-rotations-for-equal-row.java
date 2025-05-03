class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Math.min(helper(tops, bottoms, true, tops[0]), helper(tops, bottoms, true, bottoms[0]));
        res = Math.min(res, helper(tops, bottoms, false, tops[0]));
        res = Math.min(res, helper(tops, bottoms, false, bottoms[0]));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int helper(int[] tops, int[] bottoms, boolean isTop, int val) {
        int ans = 0;
        for (int i = 0; i < tops.length; i++) {
            if (isTop) {
                if (tops[i] == val) {}
                else if (bottoms[i] == val) ans++;
                else return Integer.MAX_VALUE;
            } else {
                if (bottoms[i] == val) {}
                else if (tops[i] == val) ans++;
                else return Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}