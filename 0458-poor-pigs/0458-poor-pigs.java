class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int tests = Math.floorDiv(minutesToTest, minutesToDie) + 1;
        while (Math.pow(tests, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}