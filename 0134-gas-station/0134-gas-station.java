class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diffArr = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            diffArr[i] = gas[i] - cost[i];
            sum += diffArr[i];
        }
        if (sum < 0) {
            return -1;
        }
        int currSum = diffArr[0];
        int res = 0;
        for (int i = 1; i < diffArr.length; i++) {
            if (currSum < 0) {
                currSum = diffArr[i];
                res = i;
            } else {
                currSum += diffArr[i];
            }
        }
        return res;
    }
}