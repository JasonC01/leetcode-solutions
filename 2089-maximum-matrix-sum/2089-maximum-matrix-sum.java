class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        long pos = 0;
        long neg = 0;
        long negCount = 0;
        for (int[] i : matrix) {
            for (int j : i) {
                if (j < 0) {
                    neg += j;
                    negCount++;
                    maxNeg = Math.max(maxNeg, j);
                } else {
                    pos += j;
                    minPos = Math.min(minPos, j);
                }
            }
        }
        if (negCount % 2 == 0) {
            return pos + Math.abs(neg);
        } else {
            if (Math.abs(maxNeg) > minPos) {
                return pos + Math.abs(neg) - (2L * minPos);
            } else {
                return pos + Math.abs(neg) + (2L * maxNeg);
            }
        }
    }
}