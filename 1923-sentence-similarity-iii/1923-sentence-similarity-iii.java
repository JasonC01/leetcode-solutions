class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int idx1 = 0;
        int idx2 = s1.length - 1;
        int idx3 = s2.length - 1;
        while (idx1 < Math.min(s1.length, s2.length) && s1[idx1].equals(s2[idx1])) {
            idx1++;
        }
        if (idx1 == Math.min(s1.length, s2.length)) {
            return true;
        }
        while (idx2 >= idx1 && idx3 >= idx1 && s1[idx2].equals(s2[idx3])) {
            idx2--;
            idx3--;
        }
        return idx1 + (s1.length - 1 - idx2) == Math.min(s1.length, s2.length);
    }
}