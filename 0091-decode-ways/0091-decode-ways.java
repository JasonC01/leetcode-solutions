class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(s, 0);
    }

    public int helper(String s, int index) {
        if (index > s.length() - 1) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int ans = 0;
        int s1 = Integer.parseInt(s.substring(index, index + 1));
int s2 = (index <= s.length() - 2) && s.charAt(index) != '0' ? Integer.parseInt(s.substring(index, index + 2)) : 0;        
        if (s1 <= 26 && s1 >= 1) {
            ans += helper(s, index + 1);
        }
        if (s2 <= 26 && s2 >= 1) {
            ans += helper(s, index + 2);
        }
        return memo[index] = ans;
    }
}