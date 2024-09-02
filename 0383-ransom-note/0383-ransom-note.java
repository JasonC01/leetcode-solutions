class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (Character c : ransomNote.toCharArray()) {
            counter[c - 97]--;
        }
        for (Character c : magazine.toCharArray()) {
            counter[c - 97]++;
        }
        for (int i : counter) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}