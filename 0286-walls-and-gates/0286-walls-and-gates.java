class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new ArrayDeque<>();
        int n = rooms.length;
        int m = rooms[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currY = curr[0];
            int currX = curr[1];
            int currDist = curr[2];
            if (currX < 0 || currY < 0 || currX > m - 1 || currY > n - 1 || currDist > rooms[currY][currX]) continue;
            rooms[currY][currX] = currDist;
            int newDist = currDist + 1;
            q.add(new int[]{currY + 1, currX, newDist});
            q.add(new int[]{currY - 1, currX, newDist});
            q.add(new int[]{currY, currX + 1, newDist});
            q.add(new int[]{currY, currX - 1, newDist});
        }
    }
}