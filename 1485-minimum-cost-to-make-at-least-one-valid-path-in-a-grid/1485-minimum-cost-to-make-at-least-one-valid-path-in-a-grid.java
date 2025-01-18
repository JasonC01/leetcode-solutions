class Solution {
    public int minCost(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] i : res) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        res[res.length - 1][res[0].length - 1] = 0;
        // [currX, currY, prevX, prevY, correctDirection]
        if (res.length > 1) {
            q.add(new int[]{res[0].length - 1, res.length - 2, res[0].length - 1, res.length - 1, 3});
        }
        if (res[0].length > 1) {
            q.add(new int[]{res[0].length - 2, res.length - 1, res[0].length - 1, res.length - 1, 1});
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int prevX = curr[2];
            int prevY = curr[3];
            int correctDirection = curr[4];
            if (res[currY][currX] > res[prevY][prevX] + (correctDirection == grid[currY][currX] ? 0 : 1)) {
                res[currY][currX] = Math.min(res[currY][currX], res[prevY][prevX] + (correctDirection == grid[currY][currX] ? 0 : 1));
                if (currX - 1 >= 0 && correctDirection != 2) {
                    q.add(new int[]{currX - 1, currY, currX, currY, 1});
                }
                if (currY - 1 >= 0 && correctDirection != 4) {
                    q.add(new int[]{currX, currY - 1, currX, currY, 3});
                }
                if (currX + 1 <= res[0].length - 1 && correctDirection != 1) {
                    q.add(new int[]{currX + 1, currY, currX, currY, 2});
                }
                if (currY + 1 <= res.length - 1 && correctDirection != 3) {
                    q.add(new int[]{currX, currY + 1, currX, currY, 4});
                }
            }

        }
        return res[0][0];
    }
}