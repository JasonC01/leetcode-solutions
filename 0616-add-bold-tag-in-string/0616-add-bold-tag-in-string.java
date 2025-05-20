class Solution {
    public String addBoldTag(String s, String[] words) {
        if (words.length == 0) return s;
        List<int[]> intervals = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.startsWith(word, i)) intervals.add(new int[]{i, i + word.length()});
            }
        }
        if (intervals.isEmpty()) return s;
    
    
        intervals.sort(Comparator.comparing(x -> x[0]));
        List<int[]> merged = new ArrayList<>();
        int currStart = intervals.get(0)[0];
        int currEnd = intervals.get(0)[1];
        for (int i = 1; i < intervals.size(); i++) {
            int[] currInterval = intervals.get(i);
            if (currInterval[0] <= currEnd) currEnd = Math.max(currEnd, currInterval[1]);
            else {
                merged.add(new int[]{currStart, currEnd});
                currStart = currInterval[0];
                currEnd = currInterval[1];
            }
        }
        merged.add(new int[]{currStart, currEnd});
        StringBuilder sb = new StringBuilder();
        int intervalIndex = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (intervalIndex < merged.size()) {
                int[] currInterval = merged.get(intervalIndex);
                if (i == currInterval[0]) {
                    sb.append("<b>");
                } else if (i == currInterval[1]) {
                    sb.append("</b>");
                    intervalIndex++;
                }
            }
            if (i < s.length()) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}