class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
    public String shortestCommonSupersequence(String str1, String str2) {
        helper(str1, str2, 0, 0);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i <= str1.length() && j <= str2.length()) {
            if (i == str1.length()) {
                sb.append(str2.substring(j));
                break;
            }
            if (j == str2.length()) {
                sb.append(str1.substring(i));
                break;
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else {
                if (helper(str1, str2, i, j + 1) < helper(str1, str2, i + 1, j)) {
                    sb.append(str2.charAt(j));
                    j++;
                } else {
                    sb.append(str1.charAt(i));
                    i++;
                }
            }
        }

        return sb.toString();
    }

    public int helper(String str1, String str2, int i, int j) {
        if (i == str1.length()) return str2.length() - j;
        if (j == str2.length()) return str1.length() - i;
        if (memo.containsKey(i) && memo.get(i).containsKey(j)) return memo.get(i).get(j);
        int res;
        if (str1.charAt(i) == str2.charAt(j)) {
            res = 1 + helper(str1, str2, i + 1, j + 1);
        } else {
            res = Math.min(helper(str1, str2, i + 1, j) + 1, helper(str1, str2, i, j + 1) + 1);
        }
        memo.computeIfAbsent(i, x -> new HashMap<>());
        memo.get(i).put(j, res);
        return res;
    }
}