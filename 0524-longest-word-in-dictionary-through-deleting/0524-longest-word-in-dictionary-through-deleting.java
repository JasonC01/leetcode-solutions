class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort(Comparator.comparing(x -> x));
        dictionary.sort((a, b) -> Integer.compare(b.length(), a.length()));
        for (String string : dictionary) {
            if (isContained(s, string)) {
                return string;
            }
        }
        return "";
    }
    
    public boolean isContained(String x, String y) {
        int first = 0;
        int second = 0;
        while (first < x.length() && second < y.length()) {
            if (x.charAt(first) == y.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return second == y.length();
    }

}