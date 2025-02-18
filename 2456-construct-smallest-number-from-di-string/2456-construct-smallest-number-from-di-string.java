class Solution {
    public String smallestNumber(String pattern) {
        List<Integer> remaining = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            remaining.add(i);
        }
        for (int i = 1; i <= 9; i++) {
            List<Integer> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove((Integer) i);
            String res = helper(pattern, 0, new StringBuilder(String.valueOf(i)), newRemaining);
            if (!res.isEmpty()) {
                return res;
            }
        }
        return "";
    }

    public String helper(String pattern, int index, StringBuilder sb, List<Integer> remaining) {
        if (index > pattern.length() - 1) {
            return sb.toString();
        }
        boolean increasing = pattern.charAt(index) == 'I';
        for (int i = 0; i < remaining.size(); i++) {
            boolean isCurrentIncreasing = remaining.get(i) > Integer.parseInt(sb.substring(sb.length() - 1));
            if ((increasing && isCurrentIncreasing) || (!increasing && !isCurrentIncreasing)) {
                List<Integer> newRemaining = new ArrayList<>(remaining);
                newRemaining.remove(i);
                sb.append(remaining.get(i));
                String res = helper(pattern, index + 1, sb, newRemaining);
                sb.deleteCharAt(sb.length() - 1);
                if (!res.isEmpty()) {
                    return res;
                }
            }
        }
        return "";
    }
}