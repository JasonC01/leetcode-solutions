class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> availableCols = new HashSet<>();
        HashSet<Integer> availableRightDiags = new HashSet<>();
        HashSet<Integer> availableLeftDiags = new HashSet<>();
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new StringBuilder());
            for (int j = 0; j < n; j++) {
                res.get(i).append('.');
            }
            availableCols.add(i);
            availableRightDiags.add(i);
            availableRightDiags.add(2 * i);
            availableRightDiags.add(2 * i + 1);
            availableLeftDiags.add(i);
            availableLeftDiags.add(-i);
        }
        return new ArrayList<>(helper(n, n, 0, availableCols, availableRightDiags, availableLeftDiags, res, new boolean[n][n]));
    }

    public HashSet<List<String>> helper(int originalN, int n, int currRow, HashSet<Integer> availableCols, HashSet<Integer> availableRightDiags, HashSet<Integer> availableLeftDiags, List<StringBuilder> res, boolean[][] visited) {
        HashSet<List<String>> ans = new HashSet<>();
        if (n == 0) {
            List<String> convertedRes = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                convertedRes.add(res.get(i).toString());
            }
            ans.add(convertedRes);
            return ans;
        }
        for (int j = 0; j < originalN; j++) {
            int leftDiag = j - currRow;
            int rightDiag = currRow + j;
            if (!availableLeftDiags.contains(leftDiag) ||
                    !availableRightDiags.contains(rightDiag) ||
            !availableCols.contains(j)) continue;
            availableCols.remove(j);
            availableRightDiags.remove(rightDiag);
            availableLeftDiags.remove(leftDiag);
            res.get(currRow).setCharAt(j, 'Q');
            ans.addAll(helper(originalN, n - 1, currRow + 1, availableCols, availableRightDiags, availableLeftDiags, res, visited));
            res.get(currRow).setCharAt(j, '.');
            availableCols.add(j);
            availableRightDiags.add(rightDiag);
            availableLeftDiags.add(leftDiag);
        }
        return ans;
    }
}