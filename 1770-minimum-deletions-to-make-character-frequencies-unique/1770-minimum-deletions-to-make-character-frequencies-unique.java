class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        HashSet<Integer> frequency = new HashSet<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        List<Integer> frequencies = new ArrayList<>(counter.values());
        frequencies.sort(Comparator.comparing(x -> x));
        int ans = 0;
        for (int freq : frequencies) {
            while (frequency.contains(freq)) {
                freq--;
                ans++;
            }
            if (freq > 0) {
                frequency.add(freq);
            }
        }
        return ans;
    }
}