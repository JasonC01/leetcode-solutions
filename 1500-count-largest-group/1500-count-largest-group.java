class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        HashMap<Integer, Integer> ansCount = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            counter.merge(getSum(i), 1, (a, b) -> a + 1);
        }
        for (int i : counter.values()) {
            ansCount.merge(i, 1, (a, b) -> a + 1);
        }
        int ans = 0;
        for (int i : ansCount.keySet()) {
            ans = Math.max(ans, i);
        }
        return ansCount.get(ans);
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}