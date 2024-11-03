class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i).concat(s.substring(0, i)).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}