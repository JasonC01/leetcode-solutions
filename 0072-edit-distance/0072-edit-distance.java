class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return helper(word1, word2, 0, 0);
    }

    public int helper(String word1, String word2, int i, int j) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if (memo[i][j] != -1) return memo[i][j];
        int res;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = helper(word1, word2, i + 1, j + 1);
        } else {
            res = Math.min(1 + helper(word1, word2, i, j + 1),
                    Math.min(1 + helper(word1, word2, i + 1, j),
                            1 + helper(word1, word2, i + 1, j + 1)));
        }
        memo[i][j] = res;
        return res;
    }
}