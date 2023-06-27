class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        if (stockPrices.length == 2) {
            return 1;
        }
        Arrays.sort(stockPrices, Comparator.comparing(x -> x[0]));
        int[] first = stockPrices[0];
        int[] second = stockPrices[1];
        int deltaY = second[1] - first[1];
        int deltaX = second[0] - first[0];
        int ans = 1;
        for (int i = 2; i < stockPrices.length; i++) {
            int[] curr = stockPrices[i];
            int[] prev = stockPrices[i - 1];
            int deltY = curr[1] - prev[1];
            int deltX = curr[0] - prev[0];
            if (deltaY * deltX != deltaX * deltY) {
                deltaY = deltY;
                deltaX = deltX;
                ans++;
            }
        }
        return ans;
    }
}