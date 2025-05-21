class Solution {
    public List<String> restoreIpAddresses(String s) {
        return helper(s, 0, 3, new StringBuilder());
    }

    public List<String> helper(String s, int index, int remainingCount, StringBuilder res) {
        List<String> ans = new ArrayList<>();
        if (index > s.length() - 1) return ans;
        if (remainingCount == 0 && (s.length() - index <= 3)) {
            String curr = s.substring(index);
            int lastPartition = Integer.parseInt(curr);
            if (lastPartition <= 255 && (curr.charAt(0) != '0' || curr.length() == 1)) {
                int prevSize = res.length();
                res.append(curr);
                ans.add(res.toString());
                res.delete(prevSize, res.length());
                return ans;
            }
        }
        for (int i = 1; i <= 3 && index + i < s.length(); i++) {
            int curr = Integer.parseInt(s.substring(index, index + i));
            if (i > 1 && s.charAt(index) == '0') break;
            if (curr <= 255) {
                int prevSize = res.length();
                res.append(curr);
                res.append('.');
                ans.addAll(helper(s, index + i, remainingCount - 1, res));
                res.delete(prevSize, res.length());
            }
        }
        return ans;
    }
}