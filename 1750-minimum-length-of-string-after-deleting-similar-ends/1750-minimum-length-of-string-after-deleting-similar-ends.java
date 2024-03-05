class Solution {
    public int minimumLength(String s) {
        int high = s.length() - 1;
        int low = 0;
        int ans = s.length();
        while (low < high && s.charAt(low) == s.charAt(high)) {
            char curr = s.charAt(low);
            while (low < high && s.charAt(low) == curr) {
                low++;
            }
            while (low <= high && s.charAt(high) == curr) {
                high--;
            }
            ans = high - low + 1;
        }
        return ans;
    }
}