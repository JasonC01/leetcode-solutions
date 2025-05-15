class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> zeroFirst = new ArrayList<>();
        List<String> oneFirst = new ArrayList<>();
        boolean isZero = true;
        boolean isOne = true;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] == 0) {
                if (isZero) {
                    zeroFirst.add(words[i]);
                    isZero = !isZero;
                }
                if (!isOne) {
                    oneFirst.add(words[i]);
                    isOne = !isOne;
                }
            } else {
                if (!isZero) {
                    zeroFirst.add(words[i]);
                    isZero = !isZero;
                }
                if (isOne) {
                    oneFirst.add(words[i]);
                    isOne = !isOne;
                }
            }
        }
        return zeroFirst.size() > oneFirst.size() ? zeroFirst : oneFirst;
    }
}