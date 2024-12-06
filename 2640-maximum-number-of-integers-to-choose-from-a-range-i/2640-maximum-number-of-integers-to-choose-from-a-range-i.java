class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> b = new HashSet<>();
        for (int i : banned) {
            b.add(i);
        }
        int currSum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (currSum + i <= maxSum && !b.contains(i)) {
                currSum += i;
                count++;
            }
        }
        return count;
    }
}