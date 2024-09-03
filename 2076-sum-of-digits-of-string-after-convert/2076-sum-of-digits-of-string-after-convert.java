class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 96);
        }
        return Integer.parseInt(helper(sb.toString(), k));
    }

    public String helper(String s, int k) {
        if (k == 0 || s.length() == 1) {
            return s;
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            res += Integer.parseInt(String.valueOf(c));
        }
        return helper(String.valueOf(res), k - 1);
    }
}