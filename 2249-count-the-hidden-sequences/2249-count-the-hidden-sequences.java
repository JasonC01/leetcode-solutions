class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = differences[0];
        long max = differences[0];
        long curr = differences[0];
        for (int i = 1; i < differences.length; i++) {
            curr += (long) differences[i];
            min = Math.min(curr, min);
            max = Math.max(curr, max);
        }
        long up = Math.min((long) upper - max, upper);
        long down = Math.max((long) lower - min, lower);
        return (up >= down) ? (int) (up - down + 1) : 0;
    }
}