class Solution {
    public String getHappyString(int n, int k) {
        k -= 1;
        int remainingLength = n;
        char[] chars = new char[]{'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        int lowerBound = 0;
        while (remainingLength > 0) {
            int runningLimit = 0;
            for (int i = 0; i < chars.length; i++) {
                if (sb.isEmpty() || sb.charAt(sb.length() - 1) != chars[i]) {
                    int limit = (int) (runningLimit + Math.pow(2, remainingLength - 1));
                    int upperBound = lowerBound + limit;
                    if (upperBound > k) {
                        sb.append(chars[i]);
                        break;
                    }
                    runningLimit += (limit - runningLimit);
                }
            }
            remainingLength--;
            lowerBound += runningLimit;
            if (sb.length() + remainingLength < n) {
                return "";
            }
        }
        return sb.toString();
    }
}