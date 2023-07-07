class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    public int maxConsecutiveAnswers(String answerKey, int k, char tf) {
        int start = 0;
        int end = 0;
        int remaining = k;
        int ans = 0;
        char[] anskey = answerKey.toCharArray();
        while (end < answerKey.length()) {
            if (anskey[end] == tf) {
                end++;
            } else {
                if (remaining > 0) {
                    remaining--;
                } else {
                    ans = Math.max(ans, end - start);
                    while (start < anskey.length && anskey[start]== tf) {
                        start++;
                    }
                    start++;
                }
                end++;
            }
        }
        ans = Math.max(ans, end - start);
        return ans;
    }
}