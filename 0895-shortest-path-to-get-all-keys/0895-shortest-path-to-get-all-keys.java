class Solution {
    public int shortestPathAllKeys(String[] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][127];
        int keyCount = 0;
        int startX = 0;
        int startY = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char curr = grid[i].charAt(j);
                if (curr== '@') {
                    startX = j;
                    startY = i;
                }
                if (curr - 97 <= 6 && curr - 97 >= 0) {
                    keyCount++;
                }
            }
        }
        q.add(new int[]{startX, startY, 0, 0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int moves = curr[2];
            int collectedKeyCount = curr[3];
            int collectedKeys = curr[4];
            if (x > grid[0].length() - 1 || x < 0 || y > grid.length - 1 || y < 0 || visited[y][x][collectedKeys] || grid[y].charAt(x) == '#') {
                continue;
            }
            if (collectedKeyCount == keyCount) {
                ans = Math.min(ans, moves - 1);
            }
            visited[y][x][collectedKeys] = true;
            char currPos = grid[y].charAt(x);
            int newKeys = collectedKeys;
            int newCount = collectedKeyCount;
            if (currPos - 97 <= 6 && currPos - 97 >= 0) {
                int mask = 1 << (currPos - 96);
                if ((collectedKeys & mask) == 0) {
                    newKeys = collectedKeys | mask;
                    newCount++;
                }
            }
            if (currPos - 65 >= 0 && currPos - 65 <= 6) {
                if ((collectedKeys & (1 << (currPos - 64))) != 1 << (currPos - 64)) {
                    continue;
                }
            }
            q.add(new int[]{x + 1, y, moves + 1, newCount, newKeys});
            q.add(new int[]{x - 1, y, moves + 1, newCount, newKeys});
            q.add(new int[]{x, y + 1, moves + 1, newCount, newKeys});
            q.add(new int[]{x, y - 1, moves + 1, newCount, newKeys});
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}