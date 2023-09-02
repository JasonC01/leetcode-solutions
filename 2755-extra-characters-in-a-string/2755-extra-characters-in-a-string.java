class Solution {
    int[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        HashSet<String> dict = new HashSet<>();
        Collections.addAll(dict, dictionary);
        return helper(s, 0, 1, dict, 0);
    }

    public int helper(String s, int start, int end, HashSet<String> dictionary, int currMatch) {
        if (end > s.length()) {
            return s.length() - currMatch;
        }
        if (memo[start] != -1) {
            return memo[start] + start - currMatch;
        }
        int res;
        if (dictionary.contains(s.substring(start, end))) {
            res = Math.min(helper(s, end, end + 1, dictionary, currMatch + end - start), helper(s, start, end + 1, dictionary, currMatch));
        } else {
            res = Math.min(helper(s, start + 1, start + 2, dictionary, currMatch), helper(s, start, end + 1, dictionary, currMatch));
        }
        memo[start] = res - (start - currMatch);
        return res;
    }
}