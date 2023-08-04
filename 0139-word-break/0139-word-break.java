class Solution {
    HashSet<String> set;
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }

    public boolean helper(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        boolean ans = false;
        for (int i = 0; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                ans |= helper(s.substring(i));
            }
        }
        memo.put(s, ans);
        return ans;
    }
}