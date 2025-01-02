class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counter = new int[words.length + 1];
        counter[0] = 0;
        for (int i = 1; i < counter.length; i++) {
            counter[i] = counter[i - 1] + isGood(words[i - 1]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = counter[queries[i][1] + 1] - counter[queries[i][0]];
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int isGood(String s) {
        return (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) ? 1 : 0;
    }
}