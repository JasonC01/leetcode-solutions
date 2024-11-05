class Solution {
    public int minChanges(String s) {
        if (s.length() == 2) {
            if (s.equals("11") || s.equals("00")) {
                return 0;
            }
            return 1;
        }
        String subs = s.substring(0, 2);
        return (subs.equals("00") || subs.equals("11")) ? minChanges(s.substring(2)) : 1 + minChanges(s.substring(2));
    }
}