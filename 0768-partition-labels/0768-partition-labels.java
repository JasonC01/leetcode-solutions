class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i});
            } else {
                map.get(c)[1] = i;
            }
        }
        List<int[]> ranges = new ArrayList<>(map.values());
        ranges.sort(Comparator.comparing(x -> x[0]));
        int prevStart = -1;
        int prevEnd = -1;
        for (int[] range : ranges) {
            if (prevStart == -1 && prevEnd == -1) {
                prevStart = range[0];
                prevEnd = range[1];
            } else {
                int currStart = range[0];
                int currEnd = range[1];
                if (currStart < prevEnd) {
                    prevEnd = Math.max(prevEnd, currEnd);
                } else {
                    ans.add(prevEnd - prevStart + 1);
                    prevStart = currStart;
                    prevEnd = currEnd;
                }
            }
        }
        ans.add(prevEnd - prevStart + 1);
        return ans;
    }
}