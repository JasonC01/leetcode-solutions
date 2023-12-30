class Solution {
    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        int[] counter = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                counter[c - 97]++;
            }
        }
        int val = 0;
        for (int i : counter) {
            if (i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}