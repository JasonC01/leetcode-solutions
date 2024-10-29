class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 1, wordDict);
    }
    
    public boolean helper(String sb, int index, List<String> wordDict) {
        if (sb.isEmpty()) {
            return true;
        }
        if (index > sb.length()) {
            return false;
        }
        if (memo.containsKey(sb)) {
            return memo.get(sb);
        }
        if (wordDict.contains(sb.substring(0, index))) {
            boolean res = helper(sb.substring(index), 1, wordDict) || helper(sb, index + 1, wordDict);
            memo.put(sb, res);
            return res;
        }
        boolean res = helper(sb, index + 1, wordDict);
        memo.put(sb, res);
        return res;
    }
}