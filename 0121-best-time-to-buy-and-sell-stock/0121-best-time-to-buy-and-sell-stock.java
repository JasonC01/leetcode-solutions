class Solution {
    public int maxProfit(int[] prices) {
        int[] mins = new int[prices.length];
        int[] maxs = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[prices.length - 1 - i]);
            mins[i] = min;
            maxs[prices.length - 1 - i] = max;
        }
        // System.out.println(Arrays.toString(maxs));
        // System.out.println(Arrays.toString(mins));
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            ans = Math.max(maxs[i + 1] - mins[i], ans);
        }
        return ans;
    }
}