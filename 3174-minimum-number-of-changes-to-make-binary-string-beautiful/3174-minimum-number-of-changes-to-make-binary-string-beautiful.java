class Solution {
    public int minChanges(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String subs = s.substring(0, 2);
        return (subs.equals("00") || subs.equals("11")) ? minChanges(s.substring(2)) : 1 + minChanges(s.substring(2));
    }
}