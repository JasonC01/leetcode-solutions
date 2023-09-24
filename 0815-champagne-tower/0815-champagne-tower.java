class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Double>> ans = new ArrayList<>();
        List<Double> first = new ArrayList<>();
        first.add((double) poured);
        ans.add(first);
        for (int i = 1; i <= query_row; i++) {
            List<Double> row = new ArrayList<>();
            List<Double> prevRow = ans.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    double sum = (prevRow.get(0) - 1) / 2;
                    row.add(sum > 0 ? sum : 0);
                } else if (j == i) {
                    double sum = (prevRow.get(i - 1) - 1) / 2;
                    row.add(sum > 0 ? sum : 0);
                } else {
                    double sum = 0;
                    double firstPrev = ((prevRow.get(j - 1) - 1) / 2);
                    double secondPrev = ((prevRow.get(j) - 1) / 2);
                    sum += firstPrev > 0 ? firstPrev : 0;
                    sum += secondPrev > 0 ? secondPrev : 0;
                    row.add(sum);
                }
            }
            ans.add(row);
        }
        double res = ans.get(query_row).get(query_glass);
        return res >= 1 ? 1 : res;
    }
}