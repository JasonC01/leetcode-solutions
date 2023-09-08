class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = ans.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    row.add(prevRow.get(0));
                } else if (j == i) {
                    row.add(prevRow.get(i - 1));
                } else {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}