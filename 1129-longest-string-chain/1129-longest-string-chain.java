class Solution {
    int[] memo;
    public int longestStrChain(String[] words) {
//        memo = new int[words.length];
//        Arrays.fill(memo, -1);
        Arrays.sort(words, Comparator.comparing(String::length));
//        return helper(words, 0, 0, "");
        int ans = 0;
        memo = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            int res = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (isNeighbour(words[i], words[j])) {
                    res = Math.max(res, memo[j] + 1);
                }
            }
            memo[i] = res;
            ans = Math.max(ans, res);
        }
        return ans;
        
    }


    public boolean isNeighbour(String s1, String s2) {
        int firstIndex = 0;
        int secondIndex = 0;
        if (s1.length() != s2.length() - 1) {
            return false;
        }
        while (firstIndex < s1.length() && secondIndex < s2.length()) {
            if (s1.charAt(firstIndex) == s2.charAt(secondIndex)) {
                firstIndex++;
            }
            secondIndex++;
        }
        return firstIndex == s1.length();
    }
}