class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
        int currentExtent = 1;
        int extent = 1;
        int currentDirection = 0;
        int turns = 2;
        int[][] ans = new int[rows * cols][2];
        int[] curr = new int[]{rStart, cStart};
        int index = 0;
        while (index < rows * cols) {
//            System.out.println(Arrays.toString(curr));
            if (curr[0] < rows && curr[0] >= 0 && curr[1] < cols && curr[1] >= 0) {
                ans[index++] = Arrays.copyOf(curr, 2);
            }
            curr = new int[]{curr[0] + directions[currentDirection][0], curr[1] + directions[currentDirection][1]};
            currentExtent--;
            if (currentExtent == 0) {
                turns--;
                if (turns == 0) {
                    extent++;
                    turns = 2;
                }
                currentDirection = (currentDirection + 1) % 4;
                currentExtent = extent;
            }
        }
        return ans;
    }
}