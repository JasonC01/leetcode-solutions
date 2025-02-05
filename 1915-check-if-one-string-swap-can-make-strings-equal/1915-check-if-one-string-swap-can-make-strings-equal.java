class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Integer> differingPositions = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differingPositions.add(i);
            }
        }
        if (differingPositions.isEmpty()) {
            return true;
        }
        if (differingPositions.size() == 2) {
            int firstPos = differingPositions.get(0);
            int secondPos = differingPositions.get(1);
            return s1.charAt(firstPos) == s2.charAt(secondPos) && s1.charAt(secondPos) == s2.charAt(firstPos);
        }
        return false;
    }
}