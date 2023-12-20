class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int p = prices[0] + prices[1];
        return p > money ? money : money - p;
    }
}