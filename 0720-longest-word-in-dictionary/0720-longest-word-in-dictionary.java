class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        String ans = "";
        Arrays.sort(words, Comparator.reverseOrder());
        Arrays.sort(words, Comparator.comparing(String::length));
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                ans = s;
                set.add(s);
            }
        }
        return ans;
    }
}