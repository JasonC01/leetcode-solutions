class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] counter = new int[s.length()][26];
        counter[0][s.charAt(0) - 97]++;
        for (int i = 1; i < s.length() - 1; i++) {
            counter[i] = Arrays.copyOf(counter[i - 1], 26);
            counter[i][s.charAt(i) - 97]++;
        }
        HashMap<Character, Integer> leftMost = new HashMap<>();
        HashMap<Character, Integer> rightMost = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!leftMost.containsKey(s.charAt(i))) {
                leftMost.put(s.charAt(i), i);
            }
            if (!rightMost.containsKey(s.charAt(s.length() - 1 - i))) {
                rightMost.put(s.charAt(s.length() - 1 - i), s.length() - 1 - i);
            }
        }
        
        int ans = 0;
        for (char c : leftMost.keySet()) {
            int left = leftMost.get(c);
            int right = rightMost.get(c);
            if (left >= right) {
                continue;
            }
            for (int i = 0; i < 26; i++) {
                if (counter[right - 1][i] - counter[left][i] > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}