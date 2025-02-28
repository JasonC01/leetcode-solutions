class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                } else {
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int firstIndex = 0;
        int secondIndex = 0;
        int commonIndex = 0;
        String common = backTrack(str1, str2, memo);
        System.out.println(common);
        while (firstIndex < str1.length() && secondIndex < str2.length() && commonIndex < common.length()) {
            while (firstIndex < str1.length() && str1.charAt(firstIndex) != common.charAt(commonIndex)) {
                sb.append(str1.charAt(firstIndex));
                firstIndex++;
            }
            firstIndex++;
            while (secondIndex < str2.length() && str2.charAt(secondIndex) != common.charAt(commonIndex)) {
                sb.append(str2.charAt(secondIndex));
                secondIndex++;
            }
            secondIndex++;
            sb.append(common.charAt(commonIndex));
            commonIndex++;
        }
        sb.append(str1.substring(firstIndex));
        sb.append(str2.substring(secondIndex));
        return sb.toString();
    }
    
    public String backTrack(String str1, String str2, int[][] memo) {
        StringBuilder sb = new StringBuilder();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < str1.length() && secondIndex < str2.length()) {
            if (str1.charAt(firstIndex) == str2.charAt(secondIndex)) {
                sb.append(str1.charAt(firstIndex));
                firstIndex++;
                secondIndex++;
            } else {
                if (memo[firstIndex][secondIndex + 1] > memo[firstIndex + 1][secondIndex]) {
                    secondIndex++;
                } else {
                    firstIndex++;
                }
            }
        }
        return sb.toString();
    }
}