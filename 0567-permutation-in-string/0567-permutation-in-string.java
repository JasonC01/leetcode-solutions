class Solution {
     public boolean checkInclusion(String s1, String s2) {
        int[] counter = new int[26];
        char[] cArr1 = s1.toCharArray();
        char[] cArr2 = s2.toCharArray();
        for (char c : cArr1) {
            counter[c - 97] += 1;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] counter2 = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                counter2[cArr2[j] - 97] += 1;
            }
            if (Arrays.equals(counter, counter2)) {
                return true;
            }
        }
        return false;
    }
}