class Solution {
     public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        return Math.min(Math.abs(sx - fx), Math.abs(sy - fy)) + Math.abs(Math.abs(sx - fx) - Math.abs(sy - fy)) <= t;
    }
}