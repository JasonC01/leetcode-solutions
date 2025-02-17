class Solution {
    HashSet<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        for (int i = 1; i <= tiles.length(); i++) {
            helper(tiles, i, new StringBuilder());
        }
        return set.size();
    }
    
    public void helper(String s, int length, StringBuilder sb) {
        if (sb.length() == length) {
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(s.substring(0, i).concat(s.substring(i + 1)), length, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}