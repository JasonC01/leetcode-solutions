class Solution {
    public int maxVowels(String s, int k) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                arr[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int ans = sum;
        for (int i = k; i < s.length(); i++) {
            sum += arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}