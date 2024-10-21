class Solution {
    public int maxUniqueSplit(String s) {
        return helper(s, 0, 0, new HashSet<>());
    }

    public int helper(String s, int index, int start, HashSet<String> set) {
        if (index > s.length() - 1) {
            if (start < s.length()) {
                if (!s.substring(start).isEmpty() && !set.contains(s.substring(start))) {
                    return set.size() + 1;
                }
                return Integer.MIN_VALUE;
            }
            return set.size();
        }
        HashSet<String> newSet = new HashSet<>(set);
        if (!s.substring(start, index + 1).isEmpty() && newSet.contains(s.substring(start, index + 1))) {
            return helper(s, index + 1, start, new HashSet<>(set));
        }
        newSet.add(s.substring(start, index + 1));
        return Math.max(helper(s, index + 1, start, new HashSet<>(set)), helper(s, index + 1, index + 1, newSet));
    }
}