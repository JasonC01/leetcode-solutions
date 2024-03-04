class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0;
        int curr = 0;
        int low = 0;
        int high = tokens.length - 1;
        while (low <= high && (tokens[low] <= power || curr >= 1)) {
            if (tokens[low] <= power) {
                power -= tokens[low];
                curr++;
                low++;
            } else if (curr >= 1) {
                power += tokens[high];
                curr--;
                high--;
            } else {
                return ans;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }

}