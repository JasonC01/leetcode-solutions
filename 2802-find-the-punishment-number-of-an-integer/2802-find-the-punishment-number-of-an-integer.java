class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPossible(String.valueOf((int) Math.pow(i, 2)), 0, 0, i, 0)) ans += (int) Math.pow(i, 2);
        }
        return ans;
    }

    public boolean checkPossible(String num, int index, int currSum, int target, int curr) {
        if (index > num.length() - 1) {
            return currSum + curr == target;
        }
        if (currSum > target) {
            return false;
        }
        int currValue = Integer.parseInt(num.substring(index, index + 1));
        boolean ans = checkPossible(num, index + 1, currSum + curr, target, currValue);
        ans |= checkPossible(num, index + 1, currSum, target, curr * 10 + currValue);
        return ans;
    }
}